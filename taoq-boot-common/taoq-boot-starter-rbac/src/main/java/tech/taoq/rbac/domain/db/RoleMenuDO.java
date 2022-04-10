package tech.taoq.rbac.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 角色-菜单关联表
 *
 * @author keqi
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@TableName(value = "sys_role_menu")
public class RoleMenuDO {

    @ApiModelProperty("角色id")
    @TableField(value = "role_id")
    private String roleId;

    @ApiModelProperty("菜单id")
    @TableField(value = "menu_id")
    private String menuId;
}