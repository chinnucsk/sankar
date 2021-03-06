%% @author Marc Worrell <marc@worrell.nl>
%% @copyright 2009 Marc Worrell
%% Date: 2009-04-28
%% @doc Delete a predicate, no confirmation.

%% Copyright 2009 Marc Worrell
%%
%% Licensed under the Apache License, Version 2.0 (the "License");
%% you may not use this file except in compliance with the License.
%% You may obtain a copy of the License at
%% 
%%     http://www.apache.org/licenses/LICENSE-2.0
%% 
%% Unless required by applicable law or agreed to in writing, software
%% distributed under the License is distributed on an "AS IS" BASIS,
%% WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
%% See the License for the specific language governing permissions and
%% limitations under the License.

-module(action_default_delete).
-author("Marc Worrell <marc@worrell.nl").

%% interface functions
-export([
    render_action/4,
    event/2
]).

-include("zotonic.hrl").

render_action(TriggerId, TargetId, Args, Context) ->
    Id = proplists:get_value(id, Args),
    OnSuccess = proplists:get_all_values(on_success, Args),
    Postback = {predicate_delete, Id, OnSuccess},
	{PostbackMsgJS, _PickledPostback} = z_render:make_postback(Postback, click, TriggerId, TargetId, ?MODULE, Context),
	{PostbackMsgJS, Context}.


%% @doc Delete a predicate.
%% @spec event(Event, Context1) -> Context2
event(#postback{message={predicate_delete, Id, OnSuccess}}, Context) ->
    case z_acl:is_allowed(delete, Id, Context) of
        true ->
            ok = m_rules:delete(Id, Context),
			rules_service:remove_rule(binary_to_list(Id)),
             Result=m_rules:getAll(rules,Context),
			io:format("After delete ~n~p",[Result]),
    		  {Html, Context1} = z_template:render_to_iolist("rules_list.tpl", [{result,Result}], Context),
                   z_render:update("rules_list", Html, Context1);
               
        false ->
            z_render:growl_error("Only administrators can delete predicates.", Context)
    end.
