validateEmail = (email) => {

    const emailPattern = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    
    if(email.match(emailPattern))
        return true;
    else
        return false;
}


validateAndPrint = () => {

    const firstName = document.getElementById('fName').value;
    const lastName = document.getElementById('lName').value;
    const address = document.getElementById('address').value;
    const state = document.getElementById('state').value;
    const pincode = document.getElementById('zip').value;
    const genders = document.getElementsByName('gender');
    const phone = document.getElementById('phone').value;
    const email = document.getElementById('emailId').value;
    const course = document.getElementById('course').value;
    let displayMsgDiv = document.getElementById('display_msg');
    let displayDetails = document.getElementById('displayDetails');
    let msg = '';
    let status = '';
    let gender;
    
    for(i = 0; i < genders.length; i++) { 
        if(genders[i].checked) 
            gender = genders[i].value; 
    } 

    const namePattern = /^[a-zA-Z.]+$/;
    const pincodePattern = /^[0-9]{6}$/;
    const phonePattern = /^[0-9]{10}$/;

    let isNameValid = firstName.match(namePattern) && lastName.match(namePattern);
    let isPincodeValid = pincode.match(pincodePattern) ? true : false;
    let isPhoneValid = phone.match(phonePattern) ? true : false;
    let isEmailValid = validateEmail(email);
    let isAddressValid = (address === '' || address == null ) ? false : true;
    let isCourseValid = (course === '' || course == null ) ? false : true;
    let isGenderValid = (gender === '' || gender == null) ? false : true;


    if(!isNameValid)
        msg = 'Invalid Name';
    if(!isPhoneValid)
        msg += '<br>Invalid Mobile Number ';
    if(!isPincodeValid)
        msg += '<br>Invalid Zip code ';
    if(!isEmailValid)
        msg += '<br>Invalid Email Id';
    if(!isGenderValid)
        msg += '<br>Gender Not Selected';
    if(!isCourseValid)
        msg += '<br>Course Not Selected';

    if(isNameValid && isPincodeValid && isPhoneValid && isEmailValid && isAddressValid && isCourseValid && isGenderValid) 
    {
        status = "Successfully Submitted!"
        msg += "<h5>Entered Student Details: </h5>";

        let userInfo = {
            'Name': firstName + ' ' + lastName,
            'Address': address,
            'Zipcode': pincode,
            'Phone': phone,
            'EmailId':email,
            'Course':course
        };

        for(let k in userInfo){
            // console.log(k,userInfo[k]);
            msg += '<u>' + k + '</u>: ' + userInfo[k] + '<br>'
        }

        console.log(userInfo);
  
        displayMsgDiv.classList.remove('alert-danger');
        displayMsgDiv.classList.add('alert-success');
        displayDetails.classList.add('alert-info');
    }
    else
    {
        status = "Error: Following are the Invalid Student Details"
        displayMsgDiv.classList.remove('alert-success');
        displayMsgDiv.classList.add('alert-danger');
        displayDetails.classList.add('alert-info');
    }

    
    displayMsgDiv.innerHTML = status;
    displayDetails.innerHTML = msg;
    
}