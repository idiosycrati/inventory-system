package com.erovoutika.systems.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import com.erovoutika.systems.SystemsApplication;
import com.erovoutika.systems.entities.CartEntity;
import com.erovoutika.systems.entities.PostEntity;
import com.erovoutika.systems.entities.ScheduleEntity;
import com.erovoutika.systems.entities.TheCart;
import com.erovoutika.systems.entities.authorities;
import com.erovoutika.systems.entities.products;
import com.erovoutika.systems.entities.userModel;
import com.erovoutika.systems.services.SystemServiceImplementation;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.annotation.RequiredTypes;
import org.hibernate.exception.ConstraintViolationException;

// import com.erovoutika.driver.DemoApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ContentTypeUtils;
/**
 * 
 * 
 * 
 * mainController
 * 
 * 
 * 
 */
@Controller
// @Configuration
public class MainController{
    private static final Logger log = LoggerFactory.getLogger(SystemsApplication.class);

    @Autowired
    private SystemServiceImplementation systemServiceImplementation;

   

    public MainController(SystemServiceImplementation systemServiceImplementation){
        this.systemServiceImplementation=systemServiceImplementation;

    }
    @RequestMapping("/")
    public String index(Model model,Principal principal){
        List<products> products = systemServiceImplementation.findAllProducts();
        List<PostEntity> posts = systemServiceImplementation.findAllPost();
               if (principal!=null) {
            List<CartEntity>cart = systemServiceImplementation.cartList(principal.getName());
            model.addAttribute("cart", cart);
            for (CartEntity cartEntity : cart) {
                // cartEntity.getProductId().
                // log.info(cartEntity.+"tanginangyan");
            }
            
        }
        log.info(products.size()+"products count");;
        model.addAttribute("products",products);
        // model.addAttribute("pro", attributeValue)
        model.addAttribute("posts", posts);
        return "index";


    };




    @RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET})
    public String login( ) {

        return "login";
    }


    
    @RequestMapping(value="/dashboard", method={RequestMethod.POST,RequestMethod.GET})
    public String dashboard(Model model){
        List<products> products = systemServiceImplementation.findAllProducts();
        List<PostEntity> posts = systemServiceImplementation.findAllPost();
        model.addAttribute("product",products);
        model.addAttribute("schedule", new ScheduleEntity());
        model.addAttribute("posts",posts);
        return "admin";
    }

    @RequestMapping(value="/inventory", method={RequestMethod.POST,RequestMethod.GET})
    public String inventory(Model model){
        List<products> products = systemServiceImplementation.findAllProducts();
        List<PostEntity> posts = systemServiceImplementation.findAllPost();
        model.addAttribute("products",products);
        model.addAttribute("schedule", new ScheduleEntity());
        model.addAttribute("posts",posts);
        return "inventory";
    }
// TODO: PUT CODES IN SERVICE LAYER

@PostMapping("/addProduct")
    public String addProduct(@Valid products product,@RequestParam("imageFile") MultipartFile imageFile,Model model){
        product.setId(0);
        try {
          log.error((imageFile.getContentType()).toString());
            if ((imageFile.getContentType()).compareTo("image/jpeg")!=0) {
                model.addAttribute("invalidFileType", "Not A Picture");
                model.addAttribute("resub",product);
                  log.info("NOT EQUAL");
                return "dashboard";
            }else{
                log.info("EQUAL");
                systemServiceImplementation.saveProduct(imageFile,product);
                return "redirect:/dashboard";
            }
           
        } catch (Exception e) {

            log.error(e.toString());
        }
        
        
        return "redirect:/dashboard";
    }

//TODO: PUT CODES IN SERVICE LAYER
 
    @PostMapping("/register")
	public String addEmployee(@ModelAttribute("user") @Valid final userModel user, final ModelMap model, final BindingResult result) {
        model.addAttribute("user", user);
        try {
    user.setId(0);
    user.setEnabled(1);
    authorities auth = new authorities();
    auth.setAuthority("ROLE_USER");
    auth.setEmail(user.getEmail());
    log.error(user.getPassword());
    user.setAuthority(auth);
    systemServiceImplementation.saveUser(user);
}
catch(DataIntegrityViolationException e){
System.out.println(e);
model.addAttribute("existedUsername","");
    return "login";
}catch(Exception e){
System.out.println(e);
return "redirect:/login";
}
		return "login";
    }


    @GetMapping("/productDelete")
	public String productDelete(@RequestParam("productId") int theId,
									Model theModel) {
		systemServiceImplementation.productDeleteById(theId);

		return "redirect:/dashboard";			
    }
    

    // TODO: COULD SEPARATE ADD TO CART AND UPDATE CART FUNCTION
    @GetMapping("/addToCart")
	public String addToCart(
        @RequestParam("productId") int theId,
        @RequestParam("productQuantity") int productQuantity,
        Model theModel
        ,Principal pr) {
        log.error(theId+" product Id");
        systemServiceImplementation.addToCart(pr.getName(), theId,productQuantity);
        List<CartEntity>cart = systemServiceImplementation.cartList(pr.getName());
        theModel.addAttribute("cart", cart);

		return "index  :: #nav-mobile";			
    }


    @GetMapping("/cartOrder")
	public String cartOrder(

        Model theModel,Principal pr) {

        systemServiceImplementation.cOrder(pr);
		return "redirect:/";			
    }
    @PostMapping("/createSchedule")
    public String createSchedule(@Valid ScheduleEntity schedule){

        log.info(schedule.getCaption()+" caption");
        log.info(schedule.getDate()+" date");
        log.info(schedule.getTime()+" time");     
        systemServiceImplementation.addSchedule(schedule);   
        return "redirect:/dashboard";
    }

    @PostMapping("/addPost")
    public String addPost(@Valid PostEntity post,@RequestParam("imageFile") MultipartFile imageFile,Model model){
        post.setId(0);
        log.error(post.getPostCaption());
        // try {
          log.error((imageFile.getContentType()).toString());
            if ((imageFile.getContentType()).compareTo("image/jpeg")!=0) {
                model.addAttribute("invalidFileType", "Not A Picture");
                // model.addAttribute("resub",post);
                  log.info("NOT EQUAL");
                return "dashboard";
            }else{
                log.info("EQUAL");
                try {
                    systemServiceImplementation.savePost(imageFile,post);
                    
                } catch (Exception e) {
               
                    log.error(e.toString());
                }

                return "redirect:/dashboard";
            }
           
  
    }

    @GetMapping("/archivePost")
    public String archivePost(@Valid PostEntity posts,@RequestParam("postId") int postId){

    
        systemServiceImplementation.archivePost(postId);
        return "redirect:/dashboard";
    }


    // AJAX CALL DEMO
    @GetMapping("/thecall")
	public ResponseEntity<?> aCall(
        @RequestParam("productId") int theId,
                                    Model theModel
                                    ) {
     products result = systemServiceImplementation.findProductById(theId);
              
     return new ResponseEntity<>(result,HttpStatus.OK);
                                      
    }


    // RETURN FRAGMENTS UPDATED PRODUCT LIST FRAGMENT
    @GetMapping("/updateProductList")
	public String updateProductList(
        @RequestParam("productId") int theId,
                                    Model theModel
                                    ) {
 
     List<products> products = systemServiceImplementation.findAllProducts();

    theModel.addAttribute("product", products);   
     return "dashboard  :: #productList";
                                         
    }

    @RequestMapping(value="/products", method={RequestMethod.POST,RequestMethod.GET})
    public String products(Model model){
        List<products> prod = systemServiceImplementation.findAllProducts();
        List<PostEntity> posts = systemServiceImplementation.findAllPost();
        model.addAttribute("product",prod);
        model.addAttribute("schedule", new ScheduleEntity());
        model.addAttribute("posts",posts);
        return "products";
    }


    @RequestMapping(value="/reservation", method={RequestMethod.POST,RequestMethod.GET})
    public String reservation(Model model){
        return "reservation";
    }


    @RequestMapping(value="/announcements", method={RequestMethod.POST,RequestMethod.GET})
    public String announcements(Model model){
        return "announcements";
    }









}


       



