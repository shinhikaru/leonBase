#! /bin/bash
infile="GoogleBotIPList.dat"
outfile="GoogleBotHostResult.dat"

#出力ファイルが存在するかの判断
if [ -e $outfile ]; then
    echo "file is ari"
else
    echo "file is not found"
fi
#コマンドの実行結果を変数に代入する。
$ip
ip="64.233.182.90"
host $ip

$host_result
host_result=$(host $ip)
echo $host_result
