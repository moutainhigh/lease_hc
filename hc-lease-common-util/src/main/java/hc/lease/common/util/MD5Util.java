package hc.lease.common.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.security.MessageDigest;

/**
 * 采用MD5加密解密
 *
 * @author tong
 * @datetime 2017-5-24
 */
public class MD5Util {

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    public static void main(String args[]) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = randomNumberGenerator.nextBytes().toHex();
        String s = new String("/9j/4AAQSkZJRgABAQEAZABkAAD/2wBDAAUDBAQEAwUEBAQFBQUGBwwIBwcHBw8LCwkMEQ8SEhEP\n" +
                "ERETFhwXExQaFRERGCEYGh0dHx8fExciJCIeJBweHx7/2wBDAQUFBQcGBw4ICA4eFBEUHh4eHh4e\n" +
                "Hh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh7/wgARCAEMAQwDASIA\n" +
                "AhEBAxEB/8QAHAABAAMBAQEBAQAAAAAAAAAAAAUGBwQDAgEI/8QAGwEBAAMBAQEBAAAAAAAAAAAA\n" +
                "AAECAwQFBgf/2gAMAwEAAhADEAAAAdlAAAAAAAAAcXtE+4mAAAAAAAAAAAAAAAI+EfnP61sHR5IA\n" +
                "AAAAAAAAAAAADj88iw9T216tW6uhzujyOgTAAAAAAAAAAAACveOUcn0Hvoch502mKbXNVvzxFnOn\n" +
                "xgtkAAAAAAAAAAA+PvyMH0bMN7837X5wvXsbmN2kY+Q9D44JoAAAAAAAAAAAABmNnsGb8nv6LhG9\n" +
                "VSYquufzrvlOvuHb8sAAAAAAAAAAAeFH0zv/AOUGwTE74evpjrXLB9xVd8s2bk6c+v08uHo6PLjZ\n" +
                "Lnynpx2lCTfNsEWAAAAAAAAi6DqTbLJuq49HRjSGms75l96UM56L94RPBLHPszS6Zh2c1vu/P0c2\n" +
                "wZ6AAAAAAAAAUmkbbGdfNkntsvPpTIvDZegxGW1pE8cdOuLppNw9loClwAAAAAAABBzWcUKa1pPY\n" +
                "buP1auM996i+vnrnJa+iWcXe0y+OgcPWIOYnBEgAAAAAAAfmIbg6McMtugRW2UV2xX3WZn7gfKJs\n" +
                "XxBepI8n79Ef9d8benXPU/rrazSfn6cnSESAAAAAAAIyLSaHmE8cPZF8qp529pSm+V3TFJ97eia/\n" +
                "LdTO4VsAAAAAAAAAoV9oWHqxOp5ZfM+qXZryWy1VT5nbz5dQL+ETWItfULTY00xldnrrbUHObeaE\n" +
                "0AAAAAAAUK+0LD1Ym/0DS8+uM+K/ElP3PC92x9HCt2ym3it+k9NbB8SFJ6vCn8cuFL8/6/8AoT08\n" +
                "Pf1fz8JgAAAAAABQr7QcPVivr5+eP6Lt0DKpbbzqXtmGbnTqqlc0vCot3bTluxacmUS0N+5d2pYD\n" +
                "fKJXXfffw9/T+GCYAAAAAAAZRds54/pLFfPPt38inyU8mIKV6F+dW7IiYuUJpyVm4q7QfxPjz9C/\n" +
                "OAAABy8csON2Djdg4P3uHD3AAAAAAAAAAAAB/8QAKhAAAQQCAQMDBAMBAQAAAAAAAwECBAUABkAT\n" +
                "FDQREhYQFSFQICQzIzX/2gAIAQEAAQUC/aSSdEDHNez9BP8AxA1gvUqv0GySUDW6uNWVPPOUYAyi\n" +
                "luLQI2hDzpckUUVrYmnm1+u7MOEI0bREaRnLtbIMEcmRJsJNJUNi5LlAijfby5pYdYjXcu7sWwBN\n" +
                "Q8yVUVgoI7m0ZBZDjS7eXEjBii5ar6JOkOlStYhIKLLM2PGMQkqTBjsixuY9vuYVjhkjIiR9i/8A\n" +
                "Gavo6EdkqPzdpgewmvSu5rpAmmDJC+PI1yw7Y/NIxpGOGSjsWOa9uxV3chyIqui8xFRUMJhhVwCw\n" +
                "3r+EqoPfTk/H0e5GtfbVrVjyAHbxCkYIc7YxMWE22shhq4g8a1Gp9JgnnHHAKOJyo1HTYjXFEIzT\n" +
                "wopmWkUtTPp5nfQeHYRBzY59aOihr72JiH2Vmd7sWd7sedbZX50dlfiVNyTB62PIMCLCb9NzI1Xa\n" +
                "gxza7i2dlHgMrTulRf4oRiu+ljNDBBEiyrqcATAi4t9Tumv7e3gqlvaDX7/ZZ9/ssW1tCL0beVkG\n" +
                "ktGFjtK0MmRJVRUvWMNjRs45JkdshURc7cC4gApiJ6c1yerZcabXyR3lkxE2ScmLsszH7BYuwtnP\n" +
                "ItJZ2JuRYWUWCgLGysVHBkrg2+xjka5DU9cbHa5BXPjULGa9XtwFdBB/GBNSUbhLlhXWAjQbKXAQ\n" +
                "OzNxmw17sS6rFxLWuXPudfn3OvxbauTFu6xMfsFc3HbLH9W2NvJxK+wlYxsWviwZKSh8N42Pw1dX\n" +
                "q3sKEipr9a/F1uFnxqNia1Ez45BxKKrHnb0QMW1qAYXZY6Z3t7MyNSOIRqI1OKaOAyOpq5c+xQ8W\n" +
                "jZi0Xrnx4S4muQsZr1amDp61iiAEXGly48RsSwiS3/oNx8bT/O/Qbj42n+dYTQwhH2R+fJJmVl2K\n" +
                "WSykPiQ4WwdeXllJ7SHBvXypdjOBBYfZCZ8jl5V3AZryyJLH8LcfG0/zp0QUwIauAJJVZCkDI1wT\n" +
                "/iVAVHhLDMkiLtpfbA1MXvsZ8IM0YayAJJlXDkCa5wTMX1bwtx8bT/OKRghydjC1V2OX6mIpSwPB\n" +
                "2UHRtNTP1IG3F903Ug+yCcowjk7GJq/I5eOX3OD/AJcLcfG0/wA7bZLnSdarwEAgxtyx8+B4O3A9\n" +
                "8TVjdOynmWVYQgpHi7XIc+brdcB0RBsah/8AUP8Alwtx8fT/AD9tA5syktkhDmbF6tktK0sDwbAP\n" +
                "cQmOeN+tRevY5tQHMsKW4SGGbsLnNOwgyh/y4W1SmFlaeFfQwmGYTX4Dlh1cKKsqshSija0bMfT1\n" +
                "z3w4ceG3DhGcb9fgK6HWQ4qyKuDIMieicG77xINbUyZjowBxw8c6kROpIxVN00U2e42f9c/sZ/Yx\n" +
                "e49f3f8A/8QAOxEAAQIDBQMIBwgDAAAAAAAAAQIDAAQRBRITITEwQfAGFDJRYXGh4TRAQlKxwdEQ\n" +
                "FSIkM4GR8SNiov/aAAgBAwEBPwHY3TdveopZu2WVq3rFP2GfqFmWW5OqrojeYticbdUGGegiKGld\n" +
                "tZNj85GO/kj4+UTdornDzORFE/H6CHmJWzBdX/kc/wCR9YefW8arO25RPYMohlrQ/ARyXYTgrdHS\n" +
                "0h2/iKxNd+3Ze+8ZTmqumno9vZ3xYNoCUew3OirwPGUcp5NDTiXk+1rtVuJRrCVlWggEjMQtzHcv\n" +
                "Lyrr9eN8WnaJnXK+yNIrXSHHFt5nSAbwqNktlC9YDSQbqVGMA+8YwP8AYxzdG+AAMhEyqowxqYbT\n" +
                "cSBs3GEE3q0jm69y45us6rgSidSYIypCUBOmyJCczAcvdEQ6ziRhPjRUYcwd8NsLSalX2VAy2TrI\n" +
                "dEBlxHRVAL3YYvPdQi8/1CKu76QV+8uEn3B/MDt2KEKWq6kVMONrbVdWKGChJ1EYSOqMBvqjAb6o\n" +
                "CUjQbOxPT2+Nxi30KctG4gVJAhPJ+fUK3fEQ5JPtPBlaaKMTUm9KKCXRSsMSEw+0XUD8IiVsuamx\n" +
                "ebTlEzYs5LovqTl2ZwtsooTsbE9Pb43GLeUtNpVRrlDVmWss4mY71eccpahtlfteQ+cW6BNyLc0n\n" +
                "ivnA/KWJ2r+fkIlGp6YThsVu99B8osWTm5dKkTOh0zr3wcjsbE9Pb43GFXPvz8XVl30i0bOtCZm1\n" +
                "UFU7s8qfzHKXKWZHGgixfzlnuSp4r5xykeAKJVGiR/XhC2nXLIQJT96ePjHJ+Selb5eyKt2+FdI7\n" +
                "GwmWWqzjqwLvH9RPzhmplTwy6octCacTcU4ad8LecWkJUqoENPus/pqI7oWtS1XlGphicfl/0lkR\n" +
                "zuYv4l817/V//8QALREAAQMCBAQFBAMAAAAAAAAAAQACAwQREiEwMRMUMkEiIzNAUhBCUWFxkfD/\n" +
                "2gAIAQIBAT8B90Xedb9ewmnEY/ap4yBidudeeoweFu6jhEfmSJrnzZjIJrQ3bWpG4nlxVa7xBqba\n" +
                "2Wu5vCfj7FVUONtwqOQkFurHE+TpCdG1mROf0AwjJQQ8MK1t1FDHN4WmxTmlpsdKKokiyaUahxbj\n" +
                "cwLmW/ALmvwwI1UvbJElxuVRsseK7YKV/EeXacVU9ow2uFzcXeNc3F2jTq55FgAEDncp8jn76TWl\n" +
                "xsE6LB1FU9RwScrrj0rt2rjUg+1TVMbxZrPoGki+lT1BhOSdUQyG72Itpu9wsNL8isNN8igKfsCU\n" +
                "GX6Iv7/wT25eY636CNr5aJIG6BB2Qe9uxXMSflczL+VzMvyTnududOp9MqlIEVyjVRoSNLcQTJGv\n" +
                "6U6VrThKfMxm5TKiN5sCgb6NT6ZVKAYs06aAZKj3cFTeCUsXXU/wpDE03cqh7H2LNKp9IrPlslDL\n" +
                "EyNUfW5VHlyh6o27vKDgJzxFVSNfbCho1LnHy2hRR4GYUImDMBBoGYRaHboADZOja7cLhtta3t//\n" +
                "xABBEAABAwEEAwkPAwQDAAAAAAABAAIDEQQSITEiQXETIzJAUWFyobEQFDM0QlBSYnOBgpGSwdEF\n" +
                "JFMgQ5PwNYPh/9oACAEBAAY/AvOj5aVDRU7EHtNQcQfMM9ctzd2JgObCW+YXMB05tEfdNJ8txd5g\n" +
                "Mkjg1rcymtbgCbrB6I5U2NnBaKDj5lmddaqYiOugz/da3WUb+/P1Rydy89waOUmivMNRy8cxN+Q8\n" +
                "FiBfV7zg1rdWxbvaNKfUNTVfnkDB2rcP02Gnru1fhbtbJDaZ+V2Tdg45RmM7+COTnVMZJZCq8OY8\n" +
                "J/4V0aczshybUZJZDcHCfycwQihbdbxypT53eUcOYLvp405cuZqfM7JjaoyPNXyFMhZk0fM8dLTr\n" +
                "T43ZtJBUYbkGiinpyDtQOsYpk7MnCvHu/Yxouwk5jypgrpx6Dk+J3BeKFPhk4TDRbhId6kP0njxY\n" +
                "8BzXYEIStq6yvwP+8qDmmrTiCt3iG/Rj6h3Ii7MsFflx3BGORoc05go2UkvgzidyeqVijQft2uq4\n" +
                "83J3bziABrKp35FXmNVWGVkg9U14qZJHBrRmSi2yx7qfSdgEJ5rZ3vC7IRDEqpY6Z3LK68qNAGzu\n" +
                "7i11xjuG4Z05AhFCwNaNSq40CDO+I7xyANShukYcM6OCuSWeMjYmvs8jg12MbvsmzUo7Jw5+KGCW\n" +
                "tM8NRW82iNw9YUVICQORsgp8isYnO+BpXip/xLxY/wCJYRuHwNCxlu/E1b9+pUHTcVW0WuWTZgqQ\n" +
                "RAE5u1nu2aLyhVxT3nJ8mHFt9JLzwWDMploc1rb+IAxoP6i0PaXDVXumSQ4+S3WSnTyaLCdJ+ocw\n" +
                "TYoxRjRQDiwnheBIBQtdkUbjLTGPUxHUsbS/4mheGZ9AXhmfQFhaZfhCxZa39Kv3Qla9lncNd7Hq\n" +
                "QE0ge/W4NojFY7MXu9N+iwfld8fqU5tD/RGDUGMaGtGQHGG2bdKzO8gZrEVWMMf0hYQsHw8eIBoe\n" +
                "VXpL7XVqJRr56rwwd0mhYxwH3H8rwMHWtF0bNjFV1rl9xogyWyOmb/KMOMb8/T1MbiUe8YI4Yx/c\n" +
                "kxVbR+pWhx5GUaEG3nO53ZqhAI5CqmzNafU0Vg6dvxLw0/zH4WIlftet7ssQPLSv9NojAwhfS8Mj\n" +
                "xR75onyVNTI3SqrjCLla3Hhb9ZTtY5YmVm1i8aA2tK8ch+a8cg+peOQfUvHI/mvGvk0rB0rtjFSK\n" +
                "zTP+S/bfplwelJ/oX7+3UZ/HDh1q6LkMQRlY07nXRcfK5+KaTGu2hEvscXuZ+FdaYg7k3WhWg+X3\n" +
                "SLCWce8fheMTdS8PP1Lhzn4v/FpscelIsRZB0nArQlZsjYqQwSyHnwX7ayCBp8oj8oTfqdodaHej\n" +
                "XBAAUA4tv0McnSbVeLBvRcQtGS0t2SlaNuto/wCxf8hbPrWNttR+JaUtod8S4Mh2vWFkYduK3qFj\n" +
                "Oi2nFg60PuB2WFUWQS3yBXIjzDB0z2KX2X38wwdM9il9l91uk16hwAAW82YAcr3LwMHWhE9u5SHL\n" +
                "GoKdOyPdLmYrTBRwus4YHmlb/cfaLt67q5VHZ+9QL5zvoOmvY5BoW82Zo6bl4GDrW5ObuUurHAq6\n" +
                "LMXCpAI93E4OmexS+y+6EUtbta4KjbLGekK9qumzsYdRaKEJza6UbqV5wqOyljx94RGT2O6wo5h5\n" +
                "bQU2P05OxOk/jZ2prJq0a6uC0bLH7xVFu4sjdqc0Uog4YOY6vyQPLxODpnsUvsvui+Rwa0Zkqlnh\n" +
                "dJzk0Cwhg60+V2bySVB7NvYnkZSC+nQnOJ3UVHCP7ba+8p0pzkd1BGSV4a0ayqWeBz+dxovAwdaJ\n" +
                "5cUzYOJwdM9il9l90yyg6DReO1G1TMDzeo0HILRY0bArT7R3aoPZt7FHOM43UOwq4ThI0j7qWRuN\n" +
                "9+j9lFCPIbRCzV0IxX3lC1SsbI9xNLwwC0WNHuUm0pmwcTs/TPYpvZfdMtFNB7ae8IwysLoyai7m\n" +
                "FdskJB9J/wCE7dw4SHE1zxUHs29ilh9JuG1VaS1wQeRoQ6R26u5u/kSAY84W4TMc5ldEjMK5Y4iC\n" +
                "fKd+E5koLXjMFM2DibIGGu5VrtU85yNGhGOVoc06iqt3VnMHK9HFV/pOxKMs8N5513igxuAaKDuF\n" +
                "7oNImp0inNs8dwOzxr3DHMwPadRVRureYOV6KLS9J2JTppYavdmbxVBxJxsZo7yqZ05kHOa6KLW9\n" +
                "2vYmxRNoxuXGN7GK8H1IUGNMViwLgBYa+ru8vnz/xAApEAABAgMHBAMBAQAAAAAAAAABABEhMUFA\n" +
                "UWFxgZHwEKGxwVDR8eEg/9oACAEBAAE/IflBnyJCFyaGAHYVHwJgn9Iix77b7+BaeE0v48qEt55v\n" +
                "XwAx5OQoOJ7oEvKhjB6VvDRBuTcEBAA4G+83oEsA9ANRbNkQpdG9bJNnAMczcEag6zQwAgoAM4/q\n" +
                "rg2PMsAibF4pxXID33L5xbIJv7MQMF/ZlPoB+EwIGbCn7kIikD6AgYNzibYA0ACaw3VsBD0DU8Hn\n" +
                "soxhBY9Mwrfcwdw20UqAyC0wyyQdg1bE6LFTJiIJmMTBsmuNRbi4NDQ1IRShMpdlMbOshpM5Y4qP\n" +
                "2W8tuB9JxIp8h5bsLjgQ3wrCoQTi4HQRkp8857YJADkp5ECMELcbIEUZzZ3/ACIwQsaqjdECL0EA\n" +
                "Awl0Jg2iRgE4Z+FBMrytlQpPuUwCLH4SJosiMGAXpH79Dz7wTWrcDdX+YQiL2L1KcMATcN8SikLV\n" +
                "U0CA4sWOI5La2cjUIGPL7iV6dEAltQLIfwTLCcQSRthox+0GxfZCA5n4iAefynJc+aENxRNSRNN4\n" +
                "U6ML6iIIveA9nRrPIR1uookHKggAp6IOUACzAHBSUCHSo3yBN/8AoBQHIRDq+WoSk4RgsKB7alSz\n" +
                "UK5YM6JuOCLyVGQ5FPrdLsHyUxiCaD9BUx4gCY75v7EDdhUuiGTUD/caEd0XAMMtkCEDAMBaCOAx\n" +
                "hFzG5B4GZGOLV2uxQAYAC2mdCEGSUIPekFAwEcXrpTyhDp9lyjs0zGi4g+yocViHN4G0Nxww4TqH\n" +
                "xCYyCi1dHx1LgVHQ7PUwOEeJYqR8EaJywT5CCGRviVFFL4Htz/kV4sMexskCyfE6AZiVfcIP7CKY\n" +
                "B5jyoFyKi8fh6UqV/Cr86ptouVGHjoj24ntEPzmH2ocA0ilu6TKPOHOBQGDXyWj7KDmwBWZgusgP\n" +
                "vAsTNno6XFjBoSomwwijEU5/0VUbX6IDnoqRjMJVf4h3KEkQ9R6CiTFCH3QhOAI/VBou+bv/ABBJ\n" +
                "AMALM0sgvJD5k18SUek4OgTLHuABMt9D6RFznz0gAks/kgzZGWY/5DE+LRRay6TX4LznYPgvOdgQ\n" +
                "WVxERJZOm1oNAg5Eg4vRp8p7jehjIBvQryruY7dGOdbO0RAUoTJjVuTrx7PBKLLA73OwQfiQYf0h\n" +
                "og0hdkFEZLMBheO52snnOwIzYgMdohZ3Y5QpaSD7BE2w1i8TDBCQMWNDIiBNBKIczg2B/pXQl3g+\n" +
                "1I1y5kwjcX/dQ2ZO2yaJHBhxJBb5HsnnOwIC33kAEZrui5Nq9oVgAqGK564qSt6FOCpdwd3QTCDr\n" +
                "hcAh3Wex5dBYNEiKQF6fso8O49p85kbKV5zsCYihhvLndPsmCuxVkIYKm4fsXHXEAK4Q1ZS+a0H6\n" +
                "T2UFlkjbUEs6obCYEL6myYtiXAgtLQraiLyV9kUcJCc4gQcQIzwon1eKYqn0yQFPQgfiB0y464oN\n" +
                "gvjwd0AVgCiNDg5G+nSHh8MG8InHpGpKMjKEwTxkCxxIS+yKaTY3HRDAomLqfSnUcBBQKGT7obal\n" +
                "X8EwUgBYeEE9kBgOjom9Ed08Ajx3b9J0GgIuIPI90BB47ySV3DhPsUMcICViMhwR4R1PBECORVC+\n" +
                "CsFoBYmRQzFAq+AwzBVOqjGSqPaowghkSuA7IF0QGbBMQMGnzn//2gAMAwEAAgADAAAAEPPPPPPP\n" +
                "PPP/ADzzzzzzzzzzzzzzxXzzzzzzzzzzzzzzz2/rzzzzzzzzzzzzyKtf3zzzzzzzzzzzzy/h3zzz\n" +
                "zzzzzzzzzzzMHzzzzzzzzzzzzzGc+7bkbfzzzzzzzzw5TZ8hzBXzzzzzzzzzxrKdW6zzzzzzzzzz\n" +
                "/SOFRHzbzzzzzzzzxzCrGExvVTzzzzzzzzvT41367zzzzzzzzzzxffDTnzTXzzzzzzzzwKmvs5BJ\n" +
                "bzzzzzzzzxWDwfTlZfzzzzzzzza/zz79+3zzzzzwywyzzzzzzzzzzzzz/8QAKBEBAAEDAgYCAgMB\n" +
                "AAAAAAAAAREAITFBUTBhcYGRobHRwfBA4fEQ/9oACAEDAQE/EOCiIWmJ55jxfp/BgJD5gPlHb+Bo\n" +
                "8f4E5fRl0GwecEYXV5mg63da022+nn9eMchDfazN9Bq66atHdGWtD9Zm6ZzCUA2X2mrk9wM3PNjA\n" +
                "GwEAcg88UiSaw0t22BDoyLud6AISYcgJ9rfpTaSvbszLM9+OItry0BefJY3gpxaQJ2LC8nLa2k1Y\n" +
                "GZA5gX8WehxR5cUPNjdt6p0SE1NGoFRZN94Gryzslo8CBgOY3ebB0xUJSFqwQ8mTzRhgeE7JvUJJ\n" +
                "NJxX6xV+fJQLk9VfzRsEFao/BXLXh50HnUOT391rj390RkL1pWBj59/NT8M+eEZJBUaUTfB7+qIj\n" +
                "MJTrzv8AZTZPv/VfdF8/8WC14RAVIoqLPMrRtEP3VJ91OuNAfhD+2jm6u/8Aa/YKCG7gjlJgCV7U\n" +
                "qXsJDfk1gR7V+z/aU/190BprGh24futD5AEDLZq2E5IP5+atgAApDNiHETaZztU8MJLjaY0qUfLL\n" +
                "IRBLnlt81er3KB5c9ik08ZUQ5oXjdvGtDQL4hH4x3jg+60OnQkYzMMRm9FgpmUHwrwnai8sFubyM\n" +
                "dk0J1yF6GHwKas2/J/TrV/kOiBb5kT3WkkmKHUB0SjKGi8H3WgPfjd+kxMVOQjdYLOyLzaZ3oACM\n" +
                "WkwwUnimObkhyLh7BrD4l6wA8J70o94IKFzuL6iRSmhwCEzAWVJYLh8xXuPy8GBIkBN5TKZuYEzm\n" +
                "0VIXJOYCxjXW2rUvfZL3he60mbAFUNLGlKKi5kk+KXKTKsr3aCQF2beLneJq9upCymNpnHLHKub/\n" +
                "ABv/xAAnEQABAwEHBQEBAQAAAAAAAAABABExITBBUXGh0fBhgZGx4cFAEP/aAAgBAgEBPxCxBDt/\n" +
                "C4IXE/mn8DWm4N0TcjnpOHa2eT+n1Cna+tyi+5lBGDnW1KvUj2UQkQzqhutS3o/rdOvlY1jUcqjM\n" +
                "ui1Ps968owXeAB9SwRALi5UerAfmXoIDckzzBE2NIHMWVYFy7EHwiGYUsgEDCU5EBvIlcM7qiD2R\n" +
                "QrGQAfiOCuTirhXq4mOeMuups6dhXEQNs0/BpsmotNk2GZP80QQ0B9eB6Te+ggQBkBSyYy5UIYOE\n" +
                "nTdFiBlCubOWxClDRuUzZnDeG9/4QAKCe9LImIAupIcQaq7M4J7YTZ/BOuV2BR5GZH4RwwADAOgp\n" +
                "3JKeIgwsQDkwQ1ycIYxx3KAb+myajSNkS3lLZzJ3s+PMJ5DAEoMs79kbEcBCSSdC5KlH2rKUDrRB\n" +
                "IgXWPHmEwYVQKJHQJhun0/iN643xERR+BuVRW/ko9QG+jZIRY8OYWork6CKsRNKuicnJKEheN8RC\n" +
                "JB4dUbupn00TYqAfJQsWkgugAKuKPsXyRIgYlR10AYGCJuIq5TZfz//EACcQAQABAgUEAwEBAQEA\n" +
                "AAAAAAERACExQVFhcUCBkaEQsfDBUNHx/9oACAEBAAE/EP8AUxlR0Ykd4loJJ8EQkTt/g4MqTipo\n" +
                "GbXQYeAHb/BtJAxvnXGDtoiVEDpZ9T/wMsYEB/XQzqa/p5F9zErsaUOwVNhB19r0Jnlgzdqhx/vF\n" +
                "ViDE9TBqi1gQxzAb5u9svjAr6Id2lwvlIHUnE36yBXFu/c9+eVSIAhufq46tMZpIYjTXW5ZaqOEd\n" +
                "XSBdeKeaMsC1GFzLtQjMyMd2hzHAdYNQRkwGHAZGb3rNA0pbVcgOwFBC1cMPq93PQvVotgfVoYvu\n" +
                "iUYBsMY8J2LGLvf4i5rqZu/WPRDVOQU1l2UbBY9gj3Qumcm6awezalhctsLHdg71FPmVwFYA2LBs\n" +
                "UHYAR3zHdetWKFuNyKZC8OS0fqjYA0wgMUXgxPJ1g7vlGSlOYoGdZ3GTrpq2MTscFg7xrUtozOW3\n" +
                "949xoLZ2MBE1NrT6J2SE5pjjCNbLY4th7OvXN/CPIOI0O83Lk8+5HMneiY/QkQkSg2EKGBu8y6eM\n" +
                "6V6OUjVzZ6cZhffWKwAYrat0fKSoJKyslYxUyHM/UODfinrBJbgGdKxEW4uJ7pHBLQEwFgMviXag\n" +
                "k264V2VVPJSkWPYUOYw6WDHlY92hBy0rPti+q5nFYGOI5V2oZKcqR4cexRUBwKDsfLVqcoug4F4G\n" +
                "AzY0z71mrmurSkExEHunMtAbNp1oOjI+MqrPmk6wQW8CBHhpVnANoO3jJjZEo2nmGY+NkROekKou\n" +
                "E4gMnhpYyn5FIvqnwKrMG8keqwS2fsGViKdv8rk12n3WCnNaWznNh+K0rc+I54I+6ZgTJAe7df3R\n" +
                "IA7xth8iAE2v7yPiiMSbc175Hx0zWLrCdxm0mb2mjBI4xUGYsvYjCrbVBpUGlTU1FiI1LVMQ+Zc/\n" +
                "JwCNtXAq4JQyzwlxQsaYu4FcZQOmL/VFBqkDHd2dqviGp/1xHkqLJiseZqDi/NKhaochbz/Fd4P8\n" +
                "fv4KugQFyhAnBYrAgcF5X9lTeab6c7vrxvSPXvn05u0jzUSHxx6AdRgs/vESwYQvLFQA7YNNzXVT\n" +
                "+U3LWpf5UEbsRVurk1qa0IUpxZ7UpnMjn0a3Mb3vWudzHlAWhDkkvqiy66z1cs2y/drCm4RLlaNX\n" +
                "1MQcerj24dnqADbEB6xkbsVKV67NoZLGQPNF21KNbAN91OuA3Ny50aZoITkacucvozD1UrmyKPK0\n" +
                "Vuhw0W7pQ9SmQyIPtK0AEGHysUApLkJJtuIjlg59GFZIizExS99oZbjS5whFOjGlF7imHbaOQZuM\n" +
                "xwT7p/k6p7tRkIfxtTZ7qP38doY1Zd/zfUov2zWAlamPrWmVxQ9hdZsqJx1zu00XpVYe0FPNXZAo\n" +
                "Q5lW691pHfblliFclITjE9JFDcIP7U00BKg9U+KjU1lmd+eKKW1pP017ykoz2E4rBHaRqX5AfqgE\n" +
                "ZMwnpKMCi/8AZzQpqYlp2GL3SRa8Sp4leqjCtaPBraHs6v1PJu0tybAeaGpQKADADLpoV/Kz+FLk\n" +
                "0kLgirxQw3maE2PQn/KKuuZ17+j/ACneEeoqC5DH0oMw1+ttRMX5oOmnXbeIExa5VaLs2kwm0zT/\n" +
                "AAfwNX+Fn+Bq+M0wMXCTGhYzaQh5spR248tXHRgH3UQZQsloWxsTvTheUYwCzDhM0gZFBzMLRzg7\n" +
                "/EfoIq8hZh1o6S1lwApjHYqVjaWUJSbB3aiTGDG+CPLU5t0n3UxkTZLjhX2TzVnGtJLLWCYWe+x0\n" +
                "X4Gr4zxYQ93M4wu0GRBmvvKpvUT+ajGeG1ZSUIiDJ3JojAGEYf8AtTvMsmP/AGSgXEIMlLnZkr7j\n" +
                "ihe6T4XwYzg+qlcxXesJE6M5UQexF8d50OZyGuycMNmovLCy/wC0o2wh8iej/A1fGcuYxxQATDF9\n" +
                "bhC+YpRCyDN5jWEwykWqG1/j9AKwuX+5Per0qgzh/wApqVrAdFmP3vQHQ/nZ+9Zhmo4P+u1EhMLw\n" +
                "3AL5ilsP0j3VYEC4MJVa/S0Oj/A1fGbmgUbPYngLc6er4LyE5KrOOEUJEMgD0UQAgHxsaY/Iuz9f\n" +
                "Op0qbLBhnweVSNKlis4vAVZeNjON/dlodDLwKZawwOWokuWM9qtKpPFBgAwCPor8PXX6Wh0cmp/T\n" +
                "zRjIEK1LWN2JrOkojhpk/UiUEIYkYHG16yNqDxRl5ezTwXjMIL03mfiMcqNrQl+BUgYiSFoj9pUy\n" +
                "64CzgHn4RLaCjYCfOBeahjqW4tbSSb45tWl96M28vyvFXEZYGpj3vX6Wh0YOAwmSzPMAndimLCHl\n" +
                "CfvqFB4n3SoH6s+K+6ENgWlxNuwKYBeWoEFkFX9oPMFAX2PiflbRistiBdoOABSmEF2vxmvNM52d\n" +
                "ykTVm/O1q+6dNOCT4foirQPxWYAsJgFBJBAbHRCSFgSo3nkfOl6X5WQhbt264fVZ6ZMd1c1br1Do\n" +
                "V6ZnxRLXMzEQsl+CsA2TykTR0oFYBl5pMzS5CY80yPUKuMSQdj+0s4YtqyJCYjG1KkbnbNGB/t//\n" +
                "2Q==");
        System.out.println("盐：" + salt);
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));

    }
}
