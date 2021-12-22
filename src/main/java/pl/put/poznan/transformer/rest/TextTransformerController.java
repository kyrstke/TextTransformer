package pl.put.poznan.transformer.rest;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.json_format.trans_info;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;

import org.json.JSONObject;

@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(value ="/TextTransform/{text}", method = RequestMethod.GET, produces = "application/json")
    public String post(@PathVariable String text,
                        @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(value = "/TextTransform", method = RequestMethod.POST, produces = "application/json")
    public String get(@RequestBody trans_info transInfo) throws JSONException {

        // log the parameters
        logger.debug(transInfo.getText());
        logger.debug(Arrays.toString(transInfo.getTransforms()));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transInfo.getTransforms());

        JSONObject response = new JSONObject();
        response.put("text", transformer.transform(transInfo.getText()));

        return response.toString();
    }
}


