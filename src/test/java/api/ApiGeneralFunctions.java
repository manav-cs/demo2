package api;

import report.CustomLogFilter;
import stepDef.Hook;

public class ApiGeneralFunctions {

    CustomLogFilter customLogFilter = (CustomLogFilter) Hook.logFilter;

    public void printRequest(){
        customLogFilter = (CustomLogFilter) Hook.logFilter;
        Hook.scenario.log("REQUEST:"+customLogFilter.getRequestBuilder());
    }

    public void printResponse(){
        customLogFilter = (CustomLogFilter) Hook.logFilter;
        Hook.scenario.log("RESPONSE:"+customLogFilter.getResponseBuilder());
    }

    public void initializeBaseUri(String uri){
        Hook.request.baseUri(uri);
    }
}
