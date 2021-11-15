package fast_food.fast_food_be.controller.paypal;


import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import fast_food.fast_food_be.config_paypal.PaypalPaymentIntent;
import fast_food.fast_food_be.config_paypal.PaypalPaymentMethod;
import fast_food.fast_food_be.entity.paypal_link.PayPalLink;
import fast_food.fast_food_be.service.paypal.PaypalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("")
public class PayPalRestController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private PaypalService paypalService;
    private final String URL_PAYPAL_SUCCESS = "http://localhost:4200/admin/payment-success";
    private final String URL_PAYPAL_CANCEL = "http://localhost:4200/admin/payment-cancel";

    @GetMapping("/pay")
    public ResponseEntity<PayPalLink> pay(@RequestParam("price") double price) {
        String cancelUrl = this.URL_PAYPAL_CANCEL;
        String successUrl = this.URL_PAYPAL_SUCCESS;
        try {
            Payment payment = paypalService.createPayment(
                    price,
                    "USD",
                    PaypalPaymentMethod.PAYPAL,
                    PaypalPaymentIntent.SALE,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.ok(new PayPalLink(links.getHref()));
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(new PayPalLink(""), HttpStatus.OK);
    }

}
