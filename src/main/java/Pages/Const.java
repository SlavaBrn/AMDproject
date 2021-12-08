package Pages;

import java.util.HashMap;
import Util.Config;

public class Const {
  //Base constants
  private static final Config config = new Config();
  public static final HashMap<String, String> Environments = new HashMap<String, String>() {{
    put("dev", "http://localhost:8090");
    put("qa", "https://amdtp-mock-qa.phoenixfms.ca");
  }};

  public static final Boolean IS_HEADLESS = config.GetIsHeadless();
  public static final Boolean IS_E2E = config.GetIsE2e();
  public static final String BASE_URL = Environments.get(config.GetEnvironment());
  public static final String LOGIN_URL = BASE_URL + "/";
}
