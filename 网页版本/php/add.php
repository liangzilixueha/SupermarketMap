<?php
$servername = "127.0.0.1";
$username = "get_code";
$password = "hCKhrC6fpCyBKBLj";
$dbname = "get_code";

// 创建连接
$conn = mysqli_connect($servername, $username, $password, $dbname);
// 检测连接
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO rjjh (command, chinese)
VALUES ('测试', '测试')";

if (mysqli_query($conn, $sql)) {
    echo "新记录插入成功";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>