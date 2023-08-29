//package com.ncsgroup.user_service.facade.impl;
//
//import com.ncsgroup.user_service.dto.request.UserRequest;
//import com.ncsgroup.user_service.dto.response.AccountResponse;
//import com.ncsgroup.user_service.dto.response.FullNameResponse;
//import com.ncsgroup.user_service.dto.response.UserResponse;
//import com.ncsgroup.user_service.entity.Account;
//import com.ncsgroup.user_service.entity.FullName;
//import com.ncsgroup.user_service.entity.User;
//import com.ncsgroup.user_service.facade.UserFacadeService;
//import com.ncsgroup.user_service.service.AccountService;
//import com.ncsgroup.user_service.service.FullNameService;
//import com.ncsgroup.user_service.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.transaction.annotation.Transactional;
//
//import static com.ncsgroup.user_service.utils.MapperUtils.MODEL_MAPPER;
//
//@Slf4j
//@RequiredArgsConstructor
//public class UserFacadeServiceImpl implements UserFacadeService {
//    private final AccountService accountService;
//    private final FullNameService fullNameService;
//    private final UserService userService;
//
//
//    @Override
//    @Transactional
//    public UserResponse create(UserRequest request) {
//        log.info("(create) request: {}", request);
//
//        accountService.validateExistByAccount(request.getUsername());
//        User user = userService.create(request.getEmail(), request.getPhone());
//        AccountResponse accountResponse = accountService.create(request.getUsername(), request.getPassword());
//        FullNameResponse fullNameResponse = fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getLastName());
//
//        user.setAccount(MODEL_MAPPER.map(accountResponse, Account.class));
//        user.setFullName(MODEL_MAPPER.map(fullNameResponse, FullName.class));
//        userService.save(user);
//
//        return UserResponse.of(
//                user.getId(),
//                user.getEmail(),
//                user.getPhone(),
//                accountResponse,
//                fullNameResponse
//        );
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long userId) {
//        log.info("(delete) userId: {}", userId);
//
//        User user = userService.findById(userId);
//        userService.delete(userId);
//        accountService.delete(user.getAccount().getId());
//        fullNameService.delete(user.getFullName().getId());
//    }
//
//    @Override
//    @Transactional
//    public void update(Long userId, UserRequest request) {
//        log.info("(update) userId: {}, request: {}", userId, request);
//
//        User user = userService.findById(userId);
//
//        userService.update(userId, request.getEmail(), request.getPhone());
//        accountService.update(user.getAccount().getId(), request.getUsername(), request.getPassword());
//        fullNameService.update(user.getFullName().getId(), request.getFirstName(), request.getMiddleName(), request.getLastName());
//    }
//}
