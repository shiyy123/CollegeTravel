package nju.edu.travel.config;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.List;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
public class TravelMappingJackson2HttpMessageConverter extends GsonHttpMessageConverter {
    public TravelMappingJackson2HttpMessageConverter() {
        List<MediaType> mediaTypes = Lists.newArrayList();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }
}
