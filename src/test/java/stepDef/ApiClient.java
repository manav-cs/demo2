package stepDef;

public class ApiClient {
    Hook hook;

    public ApiClient() {
        hook = new Hook();
        hook.initialize_data_API();
    }

}
