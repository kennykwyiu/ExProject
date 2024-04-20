package kenny.stream.cases;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CaseThree {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Role {
        private List<Permission> permissions;
    }
    @Data
    @AllArgsConstructor
    class Permission {
        private String name;
    }

    List<Role> roleList;

    @Before
    public void init() {
        roleList = new ArrayList();

        Role adminRole = new Role();
        List<Permission> adminPermissionList = Lists.newArrayList(
                new Permission("删除"),
                new Permission("查看"),
                new Permission("导出"));
        adminRole.setPermissions(adminPermissionList);

        Role userRole = new Role();
        List<Permission> userPermissionList = Lists.newArrayList(
                new Permission("新建"),
                new Permission("修改"),
                new Permission("删除"),
                new Permission("查看"));
        userRole.setPermissions(userPermissionList);

        roleList.add(adminRole);
        roleList.add(userRole);
    }

}
