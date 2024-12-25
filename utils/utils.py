# "Point of Sale" :1,
# "WAP" :2,
# "Ecare with authentication" :3,
# "SMS" :4,
# "USSD" :5,
# "Email" :6,
# "IVR" :7,
# "Dealer(Not used)" :8,
# "Third-Party WebService" :9,
# "Third-Party Financial System" :10,
# "VC" :11,
# "P2P" :12,
# "Dealer" :13,
# "MiniCSR" :14,
# "IN Supplementary Services" :15,
# "ONC" :16,
# "B2B Ecare" :17,
# "CRA" :18,
# "Etopup" :19,
# "Dtopup" :20,
# "Ecare without authentication" :21,
# "Portal" :22,
# "Portal-Reg" :23,
# "IVR-Payment" :24,
# "Ecare-MobileApp" :25,
# "Dtopup-Tookasoft" :26,
# "ZoodFood" :27,
# "Eshop" :28,
# "ETopUp-Vira" :29,
# "ETopUp-test2" :30,
# "AIO-OTT" :31,
# "Reg" :32,
# "Arghavan" :33,
# "RighTel-Monitoring" :34,
# "Comviva IN" :35,
# "riphone" :36,
# "crm campaign" :37,
# "portal-dpt" :38,
# "USSD-Opencode" :39,
# "Ecare-TookaSoft" :40,
# "MNP" :41,
# "BSS-Test" :42,
# "security" :43,
# "ITOAM-App" :44,
# "WiFi_Mobile_Ara" :45,
# "WThree" :46,
# "lightCSR" :48,
# "SIAM" :49,
# "NPG" :50,
# "CRM" :1000,
# "OCS" :1002,

# rightelcrm
# rightelivr
# rightelussd
# rightelmyrightel
# rightelsales
# rightelrightelir
# rightelvc
# righteltopupc
# righteltopups

def get_login_and_password(channel='default'):
    channels_map = {
        37: "rightelcrm",
        1000: "rightelcrm",
        7: "rightelivr",
        24: "rightelivr",
        5: "rightelussd",
        39: "rightelussd",
        11: "rightelvc",
    }
    if channel in channels_map.keys():
        auth = {
            'LoginSystemCode': channels_map[channel],
            'Password': 'PW02h8AXnNsD9/EkOfyUVXjp4L9/2NKOlJEmAHHN98oqTDVezwsOXqAO6zI='
        }
    else:
        auth = {
            'LoginSystemCode': 102,
            'Password': '7/PuyYwNpRtSX7jDpxnl2ECAvuVYH2Mu9zxqgPGJrPYYK73MCZN7DvrDepA='
        }
        
    return auth
