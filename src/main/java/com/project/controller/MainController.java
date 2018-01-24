package com.project.controller;



import com.project.model.Clubs;
import com.project.model.Game;
import com.project.model.Player;
import com.project.model.Playerpoints;
import com.project.model.User;
import com.project.model.Userteam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.PlayerService;
import com.project.service.PlayerpointsService;
import com.project.service.ClubsService;
import com.project.service.GameService;
import com.project.service.MessageService;
import com.project.service.TypeService;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
import com.project.service.UserkService;
import com.project.service.UserteamService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private UserteamService userteamService;
    
    @Autowired
    private PlayerpointsService playerpointsService;
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private ClubsService clubsService;
    
    @Autowired
    private GameService gameService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-games")
    public String allGames(HttpServletRequest request) {
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }
    
      @GetMapping("/points-manager")
    public String pointsManager ( HttpServletRequest request) {
        
        request.setAttribute("playerpoint", playerpointsService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        return "index";
    }
 @GetMapping("/new-clubs")
    public String newClubs(HttpServletRequest request) {
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
        return "index";
    }
    
    @GetMapping("/new-player")
    public String newPlayer(HttpServletRequest request) {
       
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
         request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_PLAYER");
        return "index";
    }
    
    @GetMapping("/your-games")
    public String yourGames(HttpServletRequest request) {
        request.setAttribute("games", typeService.getUserGames());
        request.setAttribute("mode", "MODE_BETS");
        return "index";
    }

   
    
    @GetMapping("/bet-games")
    public String betGames(HttpServletRequest request) {
        request.setAttribute("games", gameService.fillTypeToGame(gameService.findAll()));        
        request.setAttribute("mode", "MODE_BETSS");
        return "index";
    }

    @GetMapping("/new-game")
    public String newGame(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }
    
    @PostMapping("/save-clubs")
    public String newClubs(Clubs clubs, BindingResult bindingResult, HttpServletRequest request) {
        clubsService.save(clubs);
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
        return "redirect:/new-clubs";
    }
    
    
    
   @PostMapping("/save-points")
    public String savePoints(Playerpoints playerpoints, Player player, BindingResult bindingResult, HttpServletRequest request) {
        playerpointsService.save(playerpoints);
         request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER"); 
        request.setAttribute("playerpoint", playerpointsService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        return "index";
    }
    
     @PostMapping("/save-player")
    public String newPlayer(Player player, BindingResult bindingResult, HttpServletRequest request) {
        playerService.save(player);
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_PLAYER"); 
        return "redirect:/new-player";
    }
    
    @PostMapping("/save-game")
    public String saveGame(@ModelAttribute Game game, BindingResult bindingResult, HttpServletRequest request) {
        gameService.save(game);
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }

    @GetMapping("/update-game")
    public String updateGame(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", gameService.findGame(id));
        request.setAttribute("mode", "MODE_UPDATE");
        request.setAttribute("message", "treść wiadomości"); //TODO
        messageService.addSuccessMessage("Zaktualizowano pozycje!");
        return "index";
    }

    @GetMapping("/delete-game")
    public String deleteGames(@RequestParam int id, HttpServletRequest request) {
        gameService.delete(id);
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }
     @GetMapping("/delete-clubs")
    public String deleteClubs(@RequestParam int id, HttpServletRequest request) {
        clubsService.delete(id);
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
        return "index";
    }
    
    
    
       @GetMapping("/delete-player")
    public String deletePlayer(@RequestParam int id, HttpServletRequest request) {
        playerService.delete(id);
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_PLAYER");
        return "index";
    }

    @GetMapping("/contact")
    public String contact(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_CONTACT");
        return "index";
    }
      @GetMapping("/createteam")
    public String createteam(HttpServletRequest request) {
       
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_CREATETEAM");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_CREATETEAM"); 
        return "createteam";
    }
     @GetMapping("/createteame")
    public String createteame(HttpServletRequest request) {
       
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_CREATETEAME");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_CREATETEAME"); 
        return "createteam";
    }
    
       @PostMapping("/save-userteam")
    public String saveteam (Userteam userteam, Player player, BindingResult bindingResult, HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
        userteam.setUser(userServiceImpl.getUserId());
        Player pricePlayer;
        int totalPrice = 0;
        for(int i=1; i<=15; i++){
            pricePlayer = playerService.findPlayer(Integer.parseInt(request.getParameter("player"+i)));
            totalPrice += pricePlayer.getPrice();
            
            for(int o=1; o<=15; o++) {
                if(o!=i) 
                    if( request.getParameter("player"+i).equals((request.getParameter("player"+o))) ) {
                        return "redirect:/createteame";
                    }
            }     
        }
    
    
        
        userteam.setTcounter(totalPrice);
        userteamService.save(userteam);
        
        if(totalPrice > 100000) {
              

              userteamService.delete(userteam.getId());
              request.setAttribute("error", "1");
            request.setAttribute("users", userServiceImpl.findAll());
            request.setAttribute("mode", "MODE_CREATETEAM"); 
            request.setAttribute("userteams", userteamService.findAll());
            request.setAttribute("mode", "MODE_CREATETEAM"); 
            request.setAttribute("players", playerService.findAll());
            request.setAttribute("mode", "MODE_CREATETEAM"); 
            return "redirect:/createteame";
        }
       
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_CREATETEAM"); 
        request.setAttribute("userteams", userteamService.findAll());
        request.setAttribute("mode", "MODE_CREATETEAM"); 
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_CREATETEAM"); 
        return "redirect:/";
    }
     @GetMapping("/myteam-4-2-2")
    public String myteam(HttpServletRequest request) {
       
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_4-4-2");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_4-4-2"); 
        return "myteam";
    }
    

}
