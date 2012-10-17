-module(template_generator).
-export([ex1/0]).
-compile(export_all).


-record(context, {module,
		  function,
		  arity,
                  file,
                  options}).
ex1() ->
    parse_trans_mod:transform_module(
      template1, [fun(Fs, _Os) ->
		    transform_ex1(Fs,_Os)
	    end], [{pt_pp_src,false}]).

get_all_lines(Device) ->
    case io:get_line(Device, "") of
        eof  -> [];
        Line -> [to_form(Line) |get_all_lines(Device)]
    end.

to_form(String)->
	io:format("err ~p",[String]),
	{ok, MTs, _} = erl_scan:string(String),
	{ok,MF} = erl_parse:parse_form(MTs),
	MF.

parse_form(Template)->
	{ok,Fd} = file:open(Template, [read]),
	Content = lists:flatten(get_all_lines(Fd)),
	io:format("~p",[Content]),
	ok=file:close(Fd),
	Content.
	
	
	
read_template()->
	Header="C:/tmp/sankar/zotonic-update/deps/parse_trans/src/templates/header.txt",
	Footer="C:/tmp/sankar/zotonic-update/deps/parse_trans/src/templates/footer.txt",
	FBody=case get_body() of
		{ok,[]}->[];
		{ok,B}->B
	end,
	FHeader=parse_form(Header),
	FFooter=parse_form(Footer),
	{ok, Module, Bin} = compile:forms(lists:flatten([FHeader,FBody,FFooter]),[binary,debug_info]),
	%Content=[read_file(Header),read_file(Footer)],
		io:format("~p",[parse_form(Module)]).
	

get_body()->
	{ok,Rec}=parse_records("../src/addressbook_pb.hrl",[]),
	{ok,RecNames}= record_names("../src/addressbook_pb.hrl",[]),
	{ok,ExportRecords}=export_records(RecNames),
	{ok,[Rec|ExportRecords]}.

transform_ex1(Forms, _Opts) ->
	
	{ok,Rec}=parse_records("C:/tmp/zotonic-update/deps/seresye/src/records/proto_template_pb.hrl",[]),
	{ok,RecNames}= record_names("C:/tmp/zotonic-update/deps/seresye/src/records/proto_template_pb.hrl",[]),
	F=parse_trans:do_insert_forms(above,compile_attribute(),Forms,#context{}),
	{ok,ExportRecords}=export_records(RecNames),
	NewF=parse_trans:do_insert_forms(above,Rec,F,#context{}),
	NewF2=parse_trans:do_insert_forms(above,ExportRecords,NewF,#context{}),
	{ok,Fd} = file:open("ex1.xfm", [write]),
	parse_trans_pp:pp_src(NewF2,"ex1.xfm"),
	file:close(Fd),
	TemplateForm=parse_trans_mod:rename_module(NewF2,template),
	{ok, Module, Bin} = compile:forms(TemplateForm,[binary,debug_info]),
	FileName="C:/tmp/zotonic-update/deps/parse_trans/ebin/template.beam",
	{ok, File}=file:open(FileName,[write]),
	file:write(File,Bin),
	%io:format(File, "~p", [Binary]),
    file:close(File),
	code:load_binary(Module,FileName , Bin),
    io:fwrite("Forms = ~p~n", [Module]),
    Forms.

compile_attribute()->
[{attribute,1,compile,{parse_transform,exprecs}}].

export_records(RecNames)->
	{ok,[{attribute,4,export_records,RecNames}]}.
parse_records(File, Opts) ->
    Cwd = ".",
    Dir = filename:dirname(File),
    IncludePath = [Cwd,Dir|inc_paths(Opts)],
    case epp:parse_file(File, IncludePath, pre_defs(Opts)) of
        {ok,Forms} ->
            {ok,record_attrs(Forms)};
        Error ->
            Error
    end.
pre_defs([{d,M,V}|Opts]) ->
    [{M,V}|pre_defs(Opts)];
pre_defs([{d,M}|Opts]) ->
    [M|pre_defs(Opts)];
pre_defs([_|Opts]) ->
    pre_defs(Opts);
pre_defs([]) -> [].

inc_paths(Opts) ->
    [P || {i,P} <- Opts, is_list(P)].

record_attrs(Forms) ->
    [A || A = {attribute,_,record,_D} <- Forms].

record_names(File, Opts) ->
	case parse_records(File, Opts) of 
		{ok,[]}->{ok,[]};
		{ok,Records}->{ok,[RecName || {attribute,_,record,{RecName,_D}} <- Records]}
		
	end.
	
