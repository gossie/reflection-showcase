package com.github.gossie.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void reflectionTest() throws Exception {
        Class<Product> productClass = Product.class;
        Constructor<Product> defaultConstructor = productClass.getConstructor();
        Object theProductAsObject = defaultConstructor.newInstance();

        assertInstanceOf(Product.class, theProductAsObject); // jetzt weiß ich, dass theProductAsObject ein Product ist

        Method setName = productClass.getMethod("setName", String.class);
        setName.invoke(theProductAsObject, "Mein Produkt");

        Method getId = productClass.getMethod("getId");
        String productId = (String) getId.invoke(theProductAsObject);

        Product theProduct = (Product) theProductAsObject;

        assertEquals(productId, theProduct.getId());
        assertEquals("Mein Produkt", theProduct.getName());

        assertSame(theProduct, theProductAsObject);
    }

}