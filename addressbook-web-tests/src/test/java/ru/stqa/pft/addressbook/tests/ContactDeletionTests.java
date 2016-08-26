package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by t_aleksandr on 8/23/16.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
  }
}