//package com.ncsgroup.user_service.controller;
//
//import com.ncsgroup.user_service.dto.common.ResponseGeneral;
//import com.ncsgroup.user_service.dto.request.UserRequest;
//import com.ncsgroup.user_service.dto.response.UserResponse;
//import com.ncsgroup.user_service.facade.UserFacadeService;
//import com.ncsgroup.user_service.service.MessageService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import static com.ncsgroup.user_service.constant.Constant.LanguageConstants.*;
//
//@Slf4j
//@RestController
//@RequestMapping("api/users")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserFacadeService userFacadeService;
//    private final MessageService messageService;
//
//    @PostMapping()
//    public ResponseGeneral<UserResponse> create(
//            @RequestBody @Valid UserRequest request,
//            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
//    ) {
//        log.info("(create) request: {}", request);
//
//        return ResponseGeneral.ofCreated(
//                messageService.getMessage(SUCCESS, language),
//                userFacadeService.create(request)
//        );
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseGeneral<Void> delete(
//            @PathVariable(name = "id") Long userId,
//            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
//    ) {
//        log.info("(delete) id: {}", userId);
//        userFacadeService.delete(userId);
//
//        return ResponseGeneral.ofSuccess(
//                messageService.getMessage(SUCCESS, language)
//        );
//    }
//
//    @PutMapping("{id}")
//    public ResponseGeneral<Void> update(
//            @PathVariable(name = "id") Long userId,
//            @RequestBody @Valid UserRequest request,
//            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
//    ) {
//        log.info("(update) id: {}, request: {}", userId, request);
//        userFacadeService.update(userId, request);
//
//        return ResponseGeneral.ofSuccess(
//                messageService.getMessage(SUCCESS, language)
//        );
//    }
//
//
//}
