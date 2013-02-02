package com.demo.asm.converters.device;


import com.demo.asm.model.device.DeviceType;
import com.demo.asm.repository.asm.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component("deviceTypeConverter")
public class DeviceTypeConverter implements Converter {

    @Autowired
    private DeviceRepository repository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
         try {
            return repository.loadDeviceTypeById(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        if (value instanceof DeviceType) {
            return String.valueOf(((DeviceType)value).getId());
        } else {
            return null;
        }
    }
}
