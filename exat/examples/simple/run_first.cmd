cd ../..
erl -pa ebin/ -pa deps/*/ebin/ -pa ../../ebin/ -boot start_sasl -s exat_app -http_port 7778 -start simple_pingagent $*

    # -eval "t:t(mtp)." \
