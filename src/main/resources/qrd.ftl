<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>

</head>
<body>
<h2>首页<h2>

    <#list userlist as user >
        欢迎 ${user.name},${user.age}
    </#list>

    <button class="a"> click me</button>
</body>
</html>