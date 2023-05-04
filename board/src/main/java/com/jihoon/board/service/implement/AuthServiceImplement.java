package com.jihoon.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihoon.board.common.util.CustomResponse;
import com.jihoon.board.dto.request.auth.SignInRequestDto;
import com.jihoon.board.dto.request.auth.SignUpRequestDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.response.auth.SignInResponseDto;
import com.jihoon.board.repository.UserRepository;
import com.jihoon.board.service.AuthService;

@Service
public class AuthServiceImplement implements AuthService {
    
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        
        String email = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();

        try {
            //* 존재하는 유저 이메일 반환 
            boolean existedUserEmail = userRepository.existsByEmail(email);
            if (existedUserEmail) return CustomResponse.existUserEmail();

            //* 존재하는 유저 닉네임 반환 
            boolean existedUserNickname = userRepository.existsByNickname(nickname);
            if (existedUserNickname) return CustomResponse.existUserNickname();

            //* 존재하는 휴대폰 번호 반환 
            boolean existedUserPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if (existedUserPhoneNumber) return CustomResponse.existUserPhoneNumber();


        } catch(Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }

}
