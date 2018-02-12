package com.project.controller;



import com.project.model.Clubs;
import com.project.model.Game;
import com.project.model.Myteam;
import com.project.model.Player;
import com.project.model.Playerpoints;
import com.project.model.Round;
import com.project.model.User;
import com.project.model.Userteam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.PlayerService;
import com.project.service.PlayerpointsServiceImpl;
import com.project.service.ClubsService;
import com.project.service.GameService;
import com.project.service.MessageService;
import com.project.service.MyteamService;
import com.project.service.RoundService;
import com.project.service.TypeService;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
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
    private RoundService roundService;
    
     @Autowired
    private MyteamService myteamService;
     
    @Autowired
    private UserteamService userteamService;
    
    @Autowired
    private PlayerpointsServiceImpl playerpointsServiceImpl;
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

    @GetMapping("/s")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        User panel = userServiceImpl.getUserId();
        
        request.setAttribute("adminu", panel.getId());
        return "index";
    }
    
    @GetMapping("/rules")
    public String rules(HttpServletRequest request) {
        
        User panel = userServiceImpl.getUserId();
        
        request.setAttribute("adminu", panel.getId());
        request.setAttribute("mode", "MODE_RULES");
        return "index";
    }

    @GetMapping("/all-games")
    public String allGames(HttpServletRequest request) {
         User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }
    
      @GetMapping("/points-manager")
    public String pointsManager ( HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
      
       
        
        request.setAttribute("playerpoint", playerpointsServiceImpl.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        request.setAttribute("adminu", panel.getId());
        return "index";
    }
    
  
    
 @GetMapping("/new-clubs")
    public String newClubs(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
         request.setAttribute("adminu", panel.getId());
        return "index";
    }
    
    @GetMapping("/new-player")
    public String newPlayer(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
        request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_CLUBS");
         request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_PLAYER");
         request.setAttribute("adminu", panel.getId());
        return "index";
    }
    
    @GetMapping("/your-games")
    public String yourGames(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
        request.setAttribute("games", typeService.getUserGames());
        request.setAttribute("mode", "MODE_BETS");
        return "index";
    }

   
    
    @GetMapping("/bet-games")
    public String betGames(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
        request.setAttribute("games", gameService.fillTypeToGame(gameService.findAll()));        
        request.setAttribute("mode", "MODE_BETSS");
        return "index";
    }

    @GetMapping("/new-game")
    public String newGame(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
          request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }
     @GetMapping("/round")
    public String round(HttpServletRequest request) {
        User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
          request.setAttribute("rounds", roundService.findAll());
        request.setAttribute("mode", "MODE_ROUND");
        return "index";
    }
       @PostMapping("/new-round")
    public String newRound (Round round, BindingResult bindingResult, HttpServletRequest request) {
        int n= Integer.parseInt(request.getParameter("number"));
        int r=0;
      round=  roundService.findRound(1);
        r= round.getNumber();
        round.setNumber(r+n);
        roundService.save(round);
       
        request.setAttribute("rounds", roundService.findAll());
        request.setAttribute("mode", "MODE_ROUND");
         
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
       int goals = 0, assists=0, lostgoals=0, penaltysave=0, penaltymissed=0, owngoals=0, firstsquad=0, cleansheet=0, yellowcards=0, redcards=0, roundpoints= 0;
       int oldpoints=0;
       int points= 0;
         
      player=  playerService.findPlayer(Integer.parseInt(request.getParameter("player.id")));
      
 
        if( player.getPosition().equals("Napastnik")){
       goals= 4*(Integer.parseInt(request.getParameter("goals")));
        assists= 3*(Integer.parseInt(request.getParameter("assists")));     
        lostgoals= 0*(Integer.parseInt(request.getParameter("lostgoals")));
        }
          if( player.getPosition().equals("Pomocnik")){
       goals= 5*(Integer.parseInt(request.getParameter("goals")));
        assists= 3*(Integer.parseInt(request.getParameter("assists")));
         if((Integer.parseInt(request.getParameter("lostgoals"))==0))cleansheet=1;
        lostgoals= 0*(Integer.parseInt(request.getParameter("lostgoals")));
        }
            if( player.getPosition().equals("Obrońca")){
       goals= 6*(Integer.parseInt(request.getParameter("goals")));
        assists= 4*(Integer.parseInt(request.getParameter("assists")));
        if((Integer.parseInt(request.getParameter("lostgoals"))==0))cleansheet=3;
        lostgoals= -1*(Integer.parseInt(request.getParameter("lostgoals")));
        }
              if( player.getPosition().equals("Bramkarz")){
       goals= 8*(Integer.parseInt(request.getParameter("goals")));
        assists= 6*(Integer.parseInt(request.getParameter("assists")));
        if((Integer.parseInt(request.getParameter("lostgoals"))==0))cleansheet=3;
        lostgoals= -1*(Integer.parseInt(request.getParameter("lostgoals")));
        }
                penaltysave= 4*(Integer.parseInt(request.getParameter("penaltysave")));
                penaltymissed= -3*(Integer.parseInt(request.getParameter("penaltymissed")));
                owngoals= -3*(Integer.parseInt(request.getParameter("owngoals")));
                if(Integer.parseInt(request.getParameter("yellowcards"))==1) yellowcards=-1;
                if(Integer.parseInt(request.getParameter("redcards"))==1) redcards=-3;
                if(Integer.parseInt(request.getParameter("firstsquad"))==1) firstsquad=2;
                if(firstsquad>0)
             points= goals+assists+lostgoals+penaltysave+penaltymissed+owngoals+yellowcards+redcards+firstsquad+cleansheet;
                else 
                      points= goals+assists+lostgoals+penaltysave+penaltymissed+owngoals+yellowcards+redcards+firstsquad;
             Playerpoints p2;
             
  if(Integer.parseInt(request.getParameter("roundnr"))==0 || Integer.parseInt(request.getParameter("roundnr"))==1)
      oldpoints=0;
  else{
  p2= playerpointsServiceImpl.findByPlayer_id(Integer.parseInt(request.getParameter("roundnr"))-1,Integer.parseInt(request.getParameter("player.id")));
     
  oldpoints=p2.getSummarypoints() ; }
        
                                   
      System.out.println(oldpoints);    
        
         playerpoints.setSummarypoints(points+oldpoints);
                playerpoints.setRoundpoints(points);
                
        playerpointsServiceImpl.save(playerpoints);
         request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER"); 
        request.setAttribute("playerpoint", playerpointsServiceImpl.findAll());
        request.setAttribute("mode", "MODE_POINTSMANAGER");
        return "redirect:/points-manager";
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
         request.setAttribute("club", clubsService.findAll());
        request.setAttribute("mode", "MODE_GAME");
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }

    @GetMapping("/update-game")
    public String updateGame(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", gameService.findGame(id));
         request.setAttribute("club", clubsService.findAll());
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
        user.getId();
        userteam.setId(user.getId());
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
        return "redirect:/myteam-4-4-2";
    }
    
    
     @GetMapping("/")
    public String myteam(HttpServletRequest request) {
         User panel = userServiceImpl.getUserId();
         request.setAttribute("adminu", panel.getId());
       User user = userServiceImpl.getUserId();
       Userteam userteam;
       Player player1, player2, player3, player4, player5, player6, player7, player8, player9, player10, player11;
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
       Myteam myteam;
       myteam = myteamService.findMyteam(user.getId());
      String formation = myteam.getFormation();
      
      Round round= roundService.findRound(1);
           int r= round.getNumber();
     Playerpoints pr1=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer1()));
     Playerpoints pr2=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer2()));
     Playerpoints pr3=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer3()));
     Playerpoints pr4=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer4()));
     Playerpoints pr5=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer5()));
     Playerpoints pr6=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer6()));
     Playerpoints pr7=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer7()));
     Playerpoints pr8=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer8()));
     Playerpoints pr9=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer9()));
     Playerpoints pr10=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer10()));
     Playerpoints pr11=  playerpointsServiceImpl.findByPlayer_id(r,Integer.parseInt(myteam.getMplayer11()));
     player1 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer1()));
     player2 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer2()));
     player3 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer3()));
     player4 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer4()));
     player5 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer5()));
     player6 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer6()));
     player7 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer7()));
     player8 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer8()));
     player9 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer9()));
     player10 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer10()));
     player11 = playerService.findPlayer(Integer.parseInt(myteam.getMplayer11()));
     
       List<Player> mplayerList = new ArrayList<>();
       
       request.setAttribute("formation", formation);
       request.setAttribute("pr1", pr1);
       request.setAttribute("pr2", pr2);
       request.setAttribute("pr3", pr3);
       request.setAttribute("pr4", pr4);
       request.setAttribute("pr5", pr5);
       request.setAttribute("pr6", pr6);
       request.setAttribute("pr7", pr7);
       request.setAttribute("pr8", pr8);
       request.setAttribute("pr9", pr9);
       request.setAttribute("pr10", pr10);
       request.setAttribute("pr11", pr11);
        request.setAttribute("p1", player1);
        request.setAttribute("p2", player2);
        request.setAttribute("p3", player3);
        request.setAttribute("p4", player4);
        request.setAttribute("p5", player5);
        request.setAttribute("p6", player6);
        request.setAttribute("p7", player7);
        request.setAttribute("p8", player8);
        request.setAttribute("p9", player9);
        request.setAttribute("p10", player10);
        request.setAttribute("p11", player11);
        request.setAttribute("budget", budget);
        request.setAttribute("mode", "MODE_MYTEAM");
        request.setAttribute("players", mplayerList);
        request.setAttribute("mode", "MODE_MYTEAM");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM"); 
         
        return "myteam";
    }

    
    
     @GetMapping("/myteam-4-4-2")
    public String myteam442(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();

            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));

        request.setAttribute("budget", budget);
         request.setAttribute("mode", "MODE_MYTEAM-4-4-2");
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-4-4-2");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-4-4-2"); 
         
        return "myteam";
    }
    
     @GetMapping("/myteam-4-3-3")
    public String myteam433(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();
//       for(int i=1; i<=15; i++) {
//            int playerNum = Integer.parseInt(userteam.getPlayer1());
//            System.out.println(playerNum);
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));
//       }

        request.setAttribute("budget", budget);
         request.setAttribute("mode", "MODE_MYTEAM-4-3-3");
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-4-3-3");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-4-3-3"); 
         
        return "myteam";
    }
    
    @GetMapping("/myteam-4-5-1")
    public String myteam451(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));


        request.setAttribute("budget", budget);
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-4-5-1");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-4-5-1"); 
         
        return "myteam";
    }
    
    @GetMapping("/myteam-5-4-1")
    public String myteam541(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();

            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));


        request.setAttribute("budget", budget);
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-5-4-1");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-5-4-1"); 
         
        return "myteam";
    }
    @GetMapping("/myteam-5-3-2")
    public String myteam532(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));

        request.setAttribute("budget", budget);
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-5-3-2");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-5-3-2"); 
         
        return "myteam";
    }
    
    @GetMapping("/myteam-3-5-2")
    public String myteam352(HttpServletRequest request) {
       User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
     
       List<Player> playerList = new ArrayList<>();

            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));


        request.setAttribute("budget", budget);
        request.setAttribute("players", playerList);
        request.setAttribute("mode", "MODE_MYTEAM-3-5-2");
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAM-3-5-2"); 
         
        return "myteam";
    }
    
          @PostMapping("/save-myteam")
    public String savemyteam (Myteam myteam, Userteam userteam,  Player player, BindingResult bindingResult, HttpServletRequest request) {
     
User user = userServiceImpl.getUserId();
        user.getId();
        myteam.setId(user.getId());

 for(int i=1; i<=11; i++){
            for(int o=1; o<=11; o++) {
                if(o!=i) 
                    if( request.getParameter("mplayer"+i).equals((request.getParameter("mplayer"+o))) ) 
                        return "redirect:/myteam-4-4-2";
                       }}

        myteam.setMplayer1(request.getParameter("mplayer1"));
        myteam.setMplayer2(request.getParameter("mplayer2"));
        myteam.setMplayer3(request.getParameter("mplayer3"));
        myteam.setMplayer4(request.getParameter("mplayer4"));
        myteam.setMplayer5(request.getParameter("mplayer5"));
        myteam.setMplayer6(request.getParameter("mplayer6"));
        myteam.setMplayer7(request.getParameter("mplayer7"));
        myteam.setMplayer8(request.getParameter("mplayer8"));
        myteam.setMplayer9(request.getParameter("mplayer9"));
        myteam.setMplayer10(request.getParameter("mplayer10"));
        myteam.setMplayer11(request.getParameter("mplayer11"));
    
    myteamService.save(myteam);

        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MYTEAMS"); 
        request.setAttribute("myteams", myteamService.findAll());
        request.setAttribute("mode", "MODE_MYTEAMS"); 
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_MYTEAMS"); 
        
        return "redirect:/";
    }
    
      @GetMapping("/transfers")
    public String trasnfers(HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
       Userteam userteam;
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
        int tr = userteam.getTransfers();
       List<Player> playerList = new ArrayList<>();

            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));

            request.setAttribute("players", playerList);
            request.setAttribute("budget", budget);
            request.setAttribute("tr", tr); 
        request.setAttribute("mode", "MODE_TRANSFERS");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_TRANSFERS"); 
    
        return "index";
    }
     
    @PostMapping("/sell-player")
    public String sellplayer (Myteam myteam, Userteam userteam,  Player player, BindingResult bindingResult, HttpServletRequest request) {
     
        User user = userServiceImpl.getUserId();
        user.getId();
         userteam = userteamService.findUserteam(user.getId());
         myteam = myteamService.findMyteam(user.getId());
        int oldbudget = userteam.getTcounter();
        int tr = userteam.getTransfers();
         Player pricePlayer;
        int price = 0;
         
            pricePlayer = playerService.findPlayer(Integer.parseInt(request.getParameter("pl")));
            price = pricePlayer.getPrice();
                  
                 String position = null;
                if( request.getParameter("pl").equals(userteam.getPlayer1()) ) {
                userteam.setPlayer1("0"); position= "bramkarz"; }
                if( request.getParameter("pl").equals(userteam.getPlayer2()) ) {
                userteam.setPlayer2("0"); position= "bramkarz";  }
                if( request.getParameter("pl").equals(userteam.getPlayer3()) ){ 
                userteam.setPlayer3("0"); position= "obrońca";}
                if( request.getParameter("pl").equals(userteam.getPlayer4()) ){ 
                userteam.setPlayer4("0"); position= "obrońca";}
                if( request.getParameter("pl").equals(userteam.getPlayer5()) ){ 
                userteam.setPlayer5("0");position= "obrońca";}
                if( request.getParameter("pl").equals(userteam.getPlayer6()) ){ 
                userteam.setPlayer6("0");position= "obrońca";}
                if( request.getParameter("pl").equals(userteam.getPlayer7()) ){ 
                userteam.setPlayer7("0");position= "obrońca";}
                if( request.getParameter("pl").equals(userteam.getPlayer8()) ){ 
                userteam.setPlayer8("0");position= "pomocnik";}
                if( request.getParameter("pl").equals(userteam.getPlayer9()) ){ 
                userteam.setPlayer9("0");position= "pomocnik";}
                if( request.getParameter("pl").equals(userteam.getPlayer10()) ){ 
                userteam.setPlayer10("0");position= "pomocnik";}
                if( request.getParameter("pl").equals(userteam.getPlayer11()) ){ 
                userteam.setPlayer11("0");position= "pomocnik";}
                 if( request.getParameter("pl").equals(userteam.getPlayer12()) ){ 
                userteam.setPlayer12("0");position= "pomocnik";}
                  if( request.getParameter("pl").equals(userteam.getPlayer13()) ){ 
                userteam.setPlayer13("0");position= "napastnik";}
                   if( request.getParameter("pl").equals(userteam.getPlayer14()) ){ 
                userteam.setPlayer14("0");position= "napastnik";}
                    if( request.getParameter("pl").equals(userteam.getPlayer15()) ){ 
                userteam.setPlayer15("0");position= "napastnik";}
                    
                 if( request.getParameter("pl").equals(myteam.getMplayer1()) ) 
                myteam.setMplayer1("0"); 
                if( request.getParameter("pl").equals(myteam.getMplayer2()) ) 
                myteam.setMplayer2("0"); 
                if( request.getParameter("pl").equals(myteam.getMplayer3()) ) 
                myteam.setMplayer3("0");
                if( request.getParameter("pl").equals(myteam.getMplayer4()) ) 
                myteam.setMplayer4("0"); 
                if( request.getParameter("pl").equals(myteam.getMplayer5()) )
                myteam.setMplayer5("0");
                if( request.getParameter("pl").equals(myteam.getMplayer6()) ) 
                myteam.setMplayer6("0");
                if( request.getParameter("pl").equals(myteam.getMplayer7()) )
                myteam.setMplayer7("0");
                if( request.getParameter("pl").equals(myteam.getMplayer8()) )
                myteam.setMplayer8("0");
                if( request.getParameter("pl").equals(myteam.getMplayer9()) ) 
                myteam.setMplayer9("0");
                if( request.getParameter("pl").equals(myteam.getMplayer10()) )
                myteam.setMplayer10("0");
                if( request.getParameter("pl").equals(myteam.getMplayer11()) )
                myteam.setMplayer11("0"); 
                    
                   myteam.setId(user.getId());    
                userteam.setId(user.getId());
         userteam.setTcounter(oldbudget-price);
         userteam.setTransfers(tr+1);
        userteamService.save(userteam);   
         myteamService.save(myteam);    
         
        request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_TRANSFERS"); 
        request.setAttribute("userteams", userteamService.findAll());
        request.setAttribute("mode", "MODE_TRANSFERS"); 
         request.setAttribute("myteams", myteamService.findAll());
        request.setAttribute("mode", "MODE_TRANSFERS"); 
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_TRENSFERS"); 
        
        if(position.equals("napastnik"))
        return "redirect:/striker";
        if(position.equals("pomocnik"))
        return "redirect:/midfielder";
        if(position.equals("obrońca"))
        return "redirect:/defender";
        if(position.equals("bramkarz"))
        return "redirect:/goalkeeper";
    return "index";
    }
    
     @GetMapping("/goalkeeper")
    public String goalkeeper (HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam(); 
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
        List<Player> playerList = new ArrayList<>();
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer1())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer2())));

      request.setAttribute("playerss", playerList);
      request.setAttribute("budget", budget);
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_GOALKEEPER");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_GOALKEEPER"); 
        return "index";
    }
    
     @GetMapping("/defender")
    public String defender (HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
        List<Player> playerList = new ArrayList<>();
          playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer3())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer4())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer5())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer6())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer7())));
            
        request.setAttribute("playerss", playerList);
        request.setAttribute("budget", budget);
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_DEFENDER");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_DEFENDER"); 
        return "index";
    }
    
     @GetMapping("/midfielder")
    public String midfielder (HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
         List<Player> playerList = new ArrayList<>();
          playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer8())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer9())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer10())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer11())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer12())));
 
        request.setAttribute("playerss", playerList);
        request.setAttribute("budget", budget);
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_MIDFIELDER");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_MIDFIELDER"); 
        return "index";
    }
    
    
     @GetMapping("/striker")
    public String striker (HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
       Userteam userteam = new Userteam();
       userteam = userteamService.findUserteam(user.getId());
        int budget= userteam.getTcounter();
        List<Player> playerList = new ArrayList<>();
         playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer13())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer14())));
            playerList.add(playerService.findPlayer(Integer.parseInt(userteam.getPlayer15())));
        
        request.setAttribute("playerss", playerList);
        request.setAttribute("budget", budget);
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_STRIKER");
      request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_STRIKER"); 
        return "index";
    }
    
    
     @PostMapping("/buy-player")
    public String buyplayer (Myteam myteam, Userteam userteam,  Player player, BindingResult bindingResult, HttpServletRequest request) {
        User user = userServiceImpl.getUserId();
        user.getId();
          myteam = myteamService.findMyteam(user.getId());
         userteam = userteamService.findUserteam(user.getId());
        int oldbudget = userteam.getTcounter();
         Player pricePlayer;
        int price = 0;

            pricePlayer = playerService.findPlayer(Integer.parseInt(request.getParameter("bs")));
            price = pricePlayer.getPrice();       
           
                    if( request.getParameter("bs").equals(userteam.getPlayer13()) ) 
                        return "redirect:/striker";
                    if( request.getParameter("bs").equals(userteam.getPlayer14()) ) 
                        return "redirect:/striker";
                    if( request.getParameter("bs").equals(userteam.getPlayer15()) ) 
                        return "redirect:/striker";
            
                  String check= "0"; 
                  if( userteam.getPlayer1().equals(check) ) 
                userteam.setPlayer1(request.getParameter("bs")); 
                  if( userteam.getPlayer2().equals(check) ) 
                userteam.setPlayer2(request.getParameter("bs")); 
                  if( userteam.getPlayer3().equals(check) ) 
                userteam.setPlayer3(request.getParameter("bs")); 
                  if( userteam.getPlayer4().equals(check) ) 
                userteam.setPlayer4(request.getParameter("bs")); 
                  if( userteam.getPlayer5().equals(check) ) 
                userteam.setPlayer5(request.getParameter("bs")); 
                  if( userteam.getPlayer6().equals(check) ) 
                userteam.setPlayer6(request.getParameter("bs")); 
                 if( userteam.getPlayer7().equals(check) ) 
                userteam.setPlayer7(request.getParameter("bs")); 
                 if( userteam.getPlayer8().equals(check) ) 
                userteam.setPlayer8(request.getParameter("bs")); 
                 if( userteam.getPlayer9().equals(check) ) 
                userteam.setPlayer9(request.getParameter("bs")); 
                 if( userteam.getPlayer10().equals(check) ) 
                userteam.setPlayer10(request.getParameter("bs")); 
                 if( userteam.getPlayer11().equals(check) ) 
                userteam.setPlayer11(request.getParameter("bs")); 
                if( userteam.getPlayer12().equals(check) ) 
                userteam.setPlayer12(request.getParameter("bs"));   
               if( userteam.getPlayer13().equals(check) ) 
                userteam.setPlayer13(request.getParameter("bs")); 
               if( userteam.getPlayer14().equals(check) ) 
                userteam.setPlayer14(request.getParameter("bs")); 
               if( userteam.getPlayer15().equals(check) ) 
                userteam.setPlayer15(request.getParameter("bs"));
               
                if( myteam.getMplayer1().equals(check) ) 
                myteam.setMplayer1(request.getParameter("bs")); 
                  if( myteam.getMplayer2().equals(check) ) 
                myteam.setMplayer2(request.getParameter("bs")); 
                  if( myteam.getMplayer3().equals(check) ) 
                myteam.setMplayer3(request.getParameter("bs")); 
                  if( myteam.getMplayer4().equals(check) ) 
                myteam.setMplayer4(request.getParameter("bs")); 
                  if( myteam.getMplayer5().equals(check) ) 
                myteam.setMplayer5(request.getParameter("bs")); 
                  if( myteam.getMplayer6().equals(check) ) 
                myteam.setMplayer6(request.getParameter("bs")); 
                 if( myteam.getMplayer7().equals(check) ) 
                myteam.setMplayer7(request.getParameter("bs")); 
                 if( myteam.getMplayer8().equals(check) ) 
                myteam.setMplayer8(request.getParameter("bs")); 
                if( myteam.getMplayer9().equals(check) ) 
                myteam.setMplayer9(request.getParameter("bs")); 
               if( myteam.getMplayer10().equals(check) ) 
                myteam.setMplayer10(request.getParameter("bs")); 
               if( myteam.getMplayer11().equals(check) ) 
                myteam.setMplayer11(request.getParameter("bs")); 
               
               userteam.setId(user.getId());
               myteam.setId(user.getId());   
          userteam.setTcounter(oldbudget+price);    
         userteamService.save(userteam);  
         myteamService.save(myteam);  
         request.setAttribute("users", userServiceImpl.findAll());
        request.setAttribute("mode", "MODE_BUYPLAYER"); 
        request.setAttribute("userteams", userteamService.findAll());
        request.setAttribute("mode", "MODE_BUYPLAYER"); 
        request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_BUYPLAYER"); 
        return "redirect:/";
    }
    
}
