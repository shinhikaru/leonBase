#! /bin/bash
infile="GoogleBotIPList.dat"
outfile="GoogleBotHostResult.dat"
path="/usr/local/glassfish3/glassfish/domains/domain1/docroot/googleBot/"
div=":"

if [ -e $path$outfile ];
then
    echo "$outfile is found,now clearning the output file."
    rm $path$outfile
else
    echo "$outfile is not found."
fi

while read -r ip;
do
    echo -e "host $ip is running..."

    #host結果を変数に代入する。
    host_result=$(host $ip)

    #hostした結果にgoogleというキーワードがあるか
    googleBot=$(echo $host_result | egrep -i google | wc -c)

    #googleが含まらない場合、google以外と判断する。
    if [ $googleBot -eq 0 ]; then
        echo $ip":is NOT google's ip address"
    else
        #hostした結果からDNSを切り出す。
        dns=$(echo $host_result | cut -d " " -f5)

        #上記で取得したDNSの最後の[.] を抜く
        dns=$(echo ${dns%.*})

        #取得したDNSに対しhostコマンドを実行する。
        host_dns_result=$(host $dns)

        #逆引き結果がgoogleであれば、ファイルに出力する。
        googleBot=$(echo $host_result | egrep -i google | wc -c)
        if [ $googleBot -eq 0 ]; then
            echo $ip":DNS lookup is failed!"
        else
            echo $ip$div$host_result >> $path$outfile
        fi
    fi
done < $path$infile

echo -e "host comannd is done."
