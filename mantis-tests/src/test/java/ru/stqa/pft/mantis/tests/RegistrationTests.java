package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Olga on 10/17/16.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}
