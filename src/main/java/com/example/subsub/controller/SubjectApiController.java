package com.example.subsub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.example.subsub.domain.Subject;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.dto.response.SubjectResponse;
import com.example.subsub.service.SubjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "메인페이지", description = "메인페이지- 과목추가 API")
@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectApiController {

    private final SubjectService subjectService;

    //생성
    @Operation(summary = "과목 정보입력하기", description = "과목과 관련된 정보를 입력하면 올라갑니다. ", tags = {"SubjectAPIController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "입력성공",
                    content = @Content(schema = @Schema(implementation = SubjectApiController.class))),
            @ApiResponse(responseCode = "400", description = "확인되지 않은 접근입니다."),
            @ApiResponse(responseCode = "404", description = "찾을 수 없습니다."),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생했습니다.")
    })

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public SubjectResponse writesave(@RequestPart AddSubjectRequest request, @RequestPart MultipartFile multipartFile, Authentication authentication) throws Exception{
        System.out.println(authentication.getName());
        Subject savedSubject = subjectService.writesave(request, multipartFile, authentication.getName());
        return new SubjectResponse(savedSubject);
    }

     // 조회
    @Operation(summary = "과목 정보 조회", description = "입력된 과목 정보를 확인합니다", tags = {"Subject Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "입력성공",
                    content = @Content(schema = @Schema(implementation = SubjectApiController.class))),
            @ApiResponse(responseCode = "400", description = "확인되지 않은 접근입니다."),
            @ApiResponse(responseCode = "404", description = "찾을 수 없습니다."),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생했습니다.")
    })

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> findById(@PathVariable Integer id) {
        Subject subject = subjectService.findById(id);
        return ResponseEntity.ok().body(new SubjectResponse(subject));
    }

    // 모두 조회
     @GetMapping("/all")
    public ResponseEntity<List<SubjectResponse>> getAllSubject(Authentication authentication) throws Exception {
         List<SubjectResponse> savedSubject = subjectService.getAllSubject(authentication.getName())
                 .stream()
                 .map(SubjectResponse::new)
                 .toList();
         return ResponseEntity.ok().body(savedSubject);
    }

    //삭제
    @Operation(summary = "과목 정보 삭제", description = "입력된 과목 정보가 삭제됩니다.", tags = {"Subject Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "입력성공",
                    content = @Content(schema = @Schema(implementation = SubjectApiController.class))),
            @ApiResponse(responseCode = "400", description = "확인되지 않은 접근입니다."),
            @ApiResponse(responseCode = "404", description = "찾을 수 없습니다."),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생했습니다.")
    })
    @DeleteMapping("/delete/{id}")
    public boolean subjectDelete(@PathVariable Integer id) {
        subjectService.subjectDelete(id);
        return true;
    }
}
