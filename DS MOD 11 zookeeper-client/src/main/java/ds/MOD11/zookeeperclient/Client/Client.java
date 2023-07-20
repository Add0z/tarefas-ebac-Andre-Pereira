package ds.MOD11.zookeeperclient.Client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class Client {

    @Autowired
    private HWClient client;




    @FeignClient(name = "Hello")
    interface HWClient {

        @RequestMapping(path = "/hello", method = RequestMethod.GET)
        @ResponseBody
        String hello();

    }

    public String Hello() {
        return client.hello();
    }
}
