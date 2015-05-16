package com.thoughtworks.fam;

import com.thoughtworks.fam.controller.UserController;
import com.thoughtworks.fam.model.Asset;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertNull;

public class UserControllerTest {

    @Test
    public void should_handle_username_is_null() throws ParseException {
        ResponseEntity<List<Asset>> assets = new UserController().getAssets(null);
        assertNull(assets);
    }

    @Test
    public void should_handle_username_is_empty_string() throws ParseException {
        ResponseEntity<List<Asset>> assets = new UserController().getAssets("");
        assertNull(assets);
    }

}
