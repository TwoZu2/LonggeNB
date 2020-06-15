package com.sjiag.Control;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;

@Controller
//执行方法前判断 用户是否有该权限
@RequiresPermissions("sys:k:find")
public class CusController {
}
