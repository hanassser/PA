package com.social.dev.controller;

import com.social.dev.common.api.ApiResult;
import com.social.dev.model.dto.CommentDTO;
import com.social.dev.model.entity.Comment;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.CommentVO;
import com.social.dev.service.CommentService;
import com.social.dev.service.UserService;
import com.social.dev.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Resource
    private CommentService bmsCommentService;
    @Resource
    private UserService umsUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(topicid);
        return ApiResult.success(lstBmsComment);
    }
    @PostMapping("/add_comment")
    public ApiResult<Comment> add_comment(@RequestHeader(value = JwtUtil.USER_NAME) String userName,
                                          @RequestBody CommentDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        Comment comment = bmsCommentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
