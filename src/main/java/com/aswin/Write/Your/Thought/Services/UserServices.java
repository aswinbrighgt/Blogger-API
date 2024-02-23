package com.aswin.Write.Your.Thought.Services;

import com.aswin.Write.Your.Thought.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    //@Autowired
    //BCryptPasswordEncoder bCryptPasswordEncoder;
    static String confirmationMailLink="http://localhost:8080/api/v1/confirm/";



//    public User cofirmToken(Long id)  {
//        Optional<ConfirmationToken> tokenoptional=tokenRepository.findById(id);
//        if (ObjectUtils.isEmpty(tokenoptional)) throw new TokenNotFoundException();
//        ConfirmationToken token=tokenoptional.get();
//        if(token.getExpiresAt().isBefore(LocalDateTime.now())) throw new TokenAlreadyExpiredException();
//        if(token.isConfirmed()) throw new TokenAlreadyVerifiedException();
//        token.setConfirmed(true);
//        token.getUser().setVerified(true);
//        token.getUser().setPassword(bCryptPasswordEncoder.encode(token.getUser().getPassword()));
//        return userRepository.save(token.getUser());
//    }

}
