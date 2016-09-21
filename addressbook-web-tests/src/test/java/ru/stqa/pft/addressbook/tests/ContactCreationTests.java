package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      File photo = new File("src/test/resources/Cat.jpg");
      ContactData contact = new ContactData()
              .withFirstname("Olga").withLastname("Test1")
              .withAddress("100 Main Street San Francisco, CA").withHomephone("516-29-08").withGroup("[none]")
              .withMobilephone("+7 888").withWorkphone("(650)11790").withEmail("olga@test.com")
              .withEmail2("olga1@test.com").withEmail3("olga2@test.com").withPhoto(photo);
      app.contact().create(contact);
      Contacts after = app.contact().all();
      assertThat(after.size(), equalTo(before.size() + 1));
      assertThat(after, equalTo(
              before.withAdded( contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

   /* @Test
  public void testCurrentDir() {
      File currentDir = new File(".");
      System.out.println(currentDir.getAbsolutePath());
      File photo = new File("src/test/resources/Cat.jpg");
      System.out.println(photo.getAbsolutePath());
      System.out.println(photo.exists());
    }*/
}
