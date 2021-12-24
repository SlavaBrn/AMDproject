package com.vs.tp.qa.general;

import com.vs.tp.qa.utils.Config;

import java.util.HashMap;

public class Const {
    //Base constants
    private static final Config config = new Config();
    public static final HashMap<String, String> Environments = new HashMap<String, String>() {{
        put("dev", "http://localhost:8090");
        put("qa", "https://amdtp-mock-qa.phoenixfms.ca");
    }};

    public static final String BROWSER = config.GetBrowser();
    public static final Boolean IS_HEADLESS = config.GetIsHeadless();
    public static final Boolean IS_E2E = config.GetIsE2e();
    public static final String BASE_URL = Environments.get(config.GetEnvironment());
    public static final String LOGIN_URL = BASE_URL + "/";
}
