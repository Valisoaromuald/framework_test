package test;

import java.util.List;

import annotation.Controleur;
import annotation.GetHttp;
import annotation.InputParam;
// import annotation.Json;
import annotation.PostHttp;
import annotation.UrlMapping;
import modele.User;
import utilitaire.ModelView;

@Controleur
public class UserController {
    // @Json
    @GetHttp(url = "/users")
    public List<User> getUsers() {
        return List.of(new User("Alice", 30), new User("Bob", 25));
    }

    @UrlMapping(url="/users/form")
    public ModelView showResearchForm() {
        ModelView mv = new ModelView();
        mv.setView("recherche_user.jsp");
        return mv;
    }

    // @Json
    @GetHttp(url = "/user/first")
    public User getFirstUser(@InputParam(paramName = "anarana") String nom) throws Exception {
        User us = new User("Alice", 30);
        if (us.getName().equals(nom)) {
            return us;
        } else {
            throw new Exception("nom incompatible");
        }
    }

    // @Json
    @GetHttp(url = "/count")
    public int countUsers() {
        return 42;
    }
}
