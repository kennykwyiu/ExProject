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
                new Permission("remove"),
                new Permission("check"),
                new Permission("export"));
        adminRole.setPermissions(adminPermissionList);

        Role userRole = new Role();
        List<Permission> userPermissionList = Lists.newArrayList(
                new Permission("create"),
                new Permission("amend"),
                new Permission("remove"),
                new Permission("check"));
        userRole.setPermissions(userPermissionList);

        roleList.add(adminRole);
        roleList.add(userRole);
    }

}
