<?php
$servername = "127.0.0.1";
$username = "get_code";
$password = "hCKhrC6fpCyBKBLj";
$dbname = "get_code";
//获取数据
$command = $_POST['command'];
$chinese = $_POST['chinese'];
// 创建连接
$conn = mysqli_connect($servername, $username, $password, $dbname);
// 检测连接
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO rjjh (command, chinese)
VALUES ('$command', '$chinese')";

if (mysqli_query($conn, $sql)) {
    echo "新记录插入成功";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>