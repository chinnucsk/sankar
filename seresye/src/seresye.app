%% -*- mode: Erlang; fill-column: 75; comment-column: 50; -*-

{application, seresye,
 [{description, "SERESYE means Swarm oriented ERlang Expert SYstem Engine. It is a library "
   "to write expert systems and rule processing engines using the Erlang "
   "programming language"},
  {vsn, "0.0.4"},
  {modules, [seresye,seresye_app,seresye_sup]},
  {registered, []},
  {applications, [kernel, stdlib]},
  {mod, {seresye_app, []}}]}.
