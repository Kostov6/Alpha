
var loggedUser=
{
	value:null,
	listeners:[],
	set logData(newValue)
	{
		for(var i=0;i<this.listeners.length;i++)
		{
			this.listeners[i](this.value,newValue);
		}
		value=newValue;
	}
}

$(document).ready(function(){
	var accessToken=getCookie("access_token");
	if(accessToken==null)
	{
		loggedUser.logData=null;
	}	
	$.get("https://api.github.com/user?access_token="+accessToken,function(jsonUser){
		var user=jsonUser.login;
		var avatarUrl=jsonUser.avatar_url;
		loggedUser.logData={
			user: user,
			avatarUrl: avatarUrl,
			accessToken: accessToken
		};
	});
});


function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return null;
}
