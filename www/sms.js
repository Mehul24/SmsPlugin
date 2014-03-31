var sms = {
    createEvent: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'SmsPlugin', // mapped to our native Java class called "Calendar"
            'openSmsView', // with this action name
            , // with this action name
            [{                  // and this array of custom arguments to create our entry
            }]
        ); 
     }
};

module.exports = sms;
