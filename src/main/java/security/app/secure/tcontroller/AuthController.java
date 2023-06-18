package security.app.secure.tcontroller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.app.secure.entity.RequestFromApi;
import security.app.secure.entity.ResponseData;
import security.app.secure.entity.UserData;
import security.app.secure.entity.dataSource;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping(value = "/processRequest", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> processRequest(@RequestBody RequestFromApi requestData) {
        // Process the request and prepare the response
        System.out.println("request =========== " + requestData.getName());
        ResponseData responseData = new ResponseData();
        responseData.setPhone("028302002");
        responseData.setFirstname("james");
        responseData.setEmail(requestData.getName()+"@gmail.com");
        responseData.setCountry("NG");

        return ResponseEntity.ok(responseData);
    }

    @PostMapping(value = "/processRequestParam/{name}")
    @ResponseBody
    public ResponseEntity<UserData> processRequestParam(@PathVariable String name){

        System.out.println("===== request variable ==== " + name);

        UserData responseData = new UserData();
        responseData.setName("titus");
        responseData.setPassword("titus");
        responseData.setEmail(name+"@gmail.com");
        responseData.setUsername("titus");

        /*if(responseData.getName().equalsIgnoreCase(name)) {
            return ResponseEntity.ok(responseData);
        }else{
            return ResponseEntity.badRequest("badrequest");
        }*/

        return ResponseEntity.ok(responseData);

    }

    @PostMapping(value = "/processRequestParam/{appid}/{name}/{source}")
    @ResponseBody
    public ResponseEntity<dataSource> processRequestParam (@PathVariable String appid, @PathVariable String name, @PathVariable String source){

        System.out.println("===== " + appid + "** " + name + "** " + source);

        dataSource data = new dataSource();
        data.setUsername("MYTEST");
        data.setPassword("MYTEST");

        return ResponseEntity.ok(data);
    }
}
