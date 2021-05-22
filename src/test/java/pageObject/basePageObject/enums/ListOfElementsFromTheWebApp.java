package pageObject.basePageObject.enums;

public enum ListOfElementsFromTheWebApp {
     LinkedIn("LinkedIn"),
     Event("Event"),
     SocialMedia("Social Media"),
     CompanyWebsite("Company Website"),
     FamilyFriend("Family or Friend");


  String name;

  ListOfElementsFromTheWebApp(String s) {
    name = s;
  }
}
