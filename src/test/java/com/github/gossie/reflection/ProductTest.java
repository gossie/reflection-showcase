package com.github.gossie.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void reflectionTest() throws Exception {
        // Ich hole mit die Klasse Product als Class Object
        Class<Product> productClass = Product.class;
        // Ich hole mir den Default Konstruktor als Constructor Objekt
        Constructor<Product> defaultConstructor = productClass.getConstructor();
        // Ich rufe den Default Konstruktor auf und erzeuge mit eine neue Instanz
        Object theProductAsObject = defaultConstructor.newInstance();

        // Jetzt weiß ich, dass theProductAsObject ein Product ist
        assertInstanceOf(Product.class, theProductAsObject);

        // Ich hole mir von der Klasse die Methode setName als Method Objekt
        Method setName = productClass.getMethod("setName", String.class);
        // Ich rufe die Methode setName an der Instanz theProductAsObject auf
        setName.invoke(theProductAsObject, "Mein Produkt");

        // Ich hole mir von der Klasse die Methode getId als Method Objekt
        Method getId = productClass.getMethod("getId");
        // Ich rufe die Methode getId an der Instanz theProductAsObject auf und merke mit den Rückgabewert
        String productId = (String) getId.invoke(theProductAsObject);

        // Alles überprüfen

        Product theProduct = (Product) theProductAsObject;

        assertEquals(productId, theProduct.getId());
        assertEquals("Mein Produkt", theProduct.getName());

        assertSame(theProduct, theProductAsObject);
    }

}