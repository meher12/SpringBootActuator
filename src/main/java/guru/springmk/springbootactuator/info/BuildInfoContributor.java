package guru.springmk.springbootactuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BuildInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String,String> data= new HashMap<String,String>();
        data.put("build.version", "2.5.6");
        builder.withDetail("buildInfo", data);
    }
}
