package com.github.mcs.arquillian.testing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
@RunAsClient
public class RestRessourceTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(RestRessource.class.getPackage());
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSayHello(@ArquillianResource URL baseUrl) throws Exception {
        String expected = "Hello world";

        String result = ClientBuilder.newClient()
                .target(baseUrl.toURI())
                .path("rest/world")
                .request()
                .get(String.class);

        assertThat(result, is(expected));
    }
}