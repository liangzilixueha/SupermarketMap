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

$sql = "SELECT * FROM rjjh";
$result = mysqli_query($conn, $sql);
//发送返回数据
if (mysqli_num_rows($result) > 0) {
    // 输出数据为json
    $arr = array();
    while($row = mysqli_fetch_assoc($result)) {
        $arr[] = $row;
    }
    echo json_encode($arr);
} else {
    echo "0 结果";
}

mysqli_close($conn);
?>