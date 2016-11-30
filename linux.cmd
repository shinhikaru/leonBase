1 #! /bin/bash
      2 infile="GoogleBotIPList.dat"
      3 outfile="GoogleBotHostResult.dat"
      4
      5 if [ -e $outfile ]; then
      6     echo "file is ari"
      7 else
      8     echo "file is not found"
      9 fi
     10
     11 div=":"
     12 #googleBot ip
     13 ip="66.249.65.122"
     14
     15 #host結果を変数に代入する。
     16 host_result=$(host $ip)
     17
     18 #hostした結果にgoogleというキーワードがあるか
     19 googleBot=$(echo $host_result | egrep -i google | wc -c)
     20
     21 #googleが含まらない場合、google以外と判断する。
     22 if [ $googleBot -eq 0 ]; then
     23     echo $ip":Not google ip address"
     24 else
     25     #hostした結果からDNSを切り出す。
     26     dns=$(echo $host_result | cut -d " " -f5)
     27
     28     #上記で取得したDNSの最後の[.] を抜く
     29     dns=$(echo ${dns%.*})
     30
     31     #取得したDNSに対しhostコマンドを実行する。
     32     host_dns_result=$(host $dns)
     33
     34     #逆引き結果がgoogleであれば、ファイルに出力する。
     35     googleBot=$(echo $host_result | egrep -i google | wc -c)
     36     if [ $googleBot -eq 0 ]; then
     37         echo $ip":DNS lookup is failed!"
     38     else
     39         echo $ip$div$host_result
     40     fi

