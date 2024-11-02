import { initializeApp } from 'https://www.gstatic.com/firebasejs/11.0.1/firebase-app.js'
import { getAnalytics } from 'https://www.gstatic.com/firebasejs/11.0.1/firebase-analytics.js'
import { getAuth, createUserWithEmailAndPassword,signInWithEmailAndPassword ,signInWithPopup,GoogleAuthProvider,signOut} from 'https://www.gstatic.com/firebasejs/11.0.1/firebase-auth.js'
import { getFirestore ,doc,setDoc} from 'https://www.gstatic.com/firebasejs/11.0.1/firebase-firestore.js'
import { getStorage,ref,uploadBytes,getDownloadURL} from 'https://www.gstatic.com/firebasejs/11.0.1/firebase-storage.js'
const firebaseConfig = {
apiKey: "AIzaSyDH66MfDs6idk7HBeqi_fSJ_mSb1BxG6jI",
authDomain: "pos-system-4c973.firebaseapp.com",
projectId: "pos-system-4c973",
storageBucket: "pos-system-4c973.appspot.com",
messagingSenderId: "184774627472",
appId: "1:184774627472:web:cb7485e3edb933c4b20815",
measurementId: "G-Z7C0F570KF"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getFirestore(app);
const storage = getStorage(app);
const analytics = getAnalytics(app);

document.getElementById('customerContext').style.display='block';
document.getElementById('productContext').style.display='none';
document.getElementById('orderContext').style.display='none';

document.getElementById('customerTab').addEventListener('click',function(event){
    event.preventDefault();
    document.getElementById('customerContext').style.display='block';
    document.getElementById('productContext').style.display='none';
    document.getElementById('orderContext').style.display='none';
    this.classList.add('active');
    document.getElementById('productTab').classList.remove('active');
    document.getElementById('orderTab').classList.remove('active');
})
document.getElementById('productTab').addEventListener('click',function(event){
    event.preventDefault();
    document.getElementById('customerContext').style.display='none';
    document.getElementById('productContext').style.display='block';
    document.getElementById('orderContext').style.display='none';
    this.classList.add('active');
    document.getElementById('customerTab').classList.remove('active');
    document.getElementById('orderTab').classList.remove('active');
})
document.getElementById('orderTab').addEventListener('click',function(event){
    event.preventDefault();
    document.getElementById('customerContext').style.display='none';
    document.getElementById('productContext').style.display='none';
    document.getElementById('orderContext').style.display='block';
    this.classList.add('active');
    document.getElementById('customerTab').classList.remove('active');
    document.getElementById('productTab').classList.remove('active');
})

document.getElementById('signupButton').addEventListener('click',function(event){
    document.getElementById('success-reg-alert').style.display='none';
    document.getElementById('error-reg-alert').style.display='none';
})
const registerNow = ()=>{
    document.getElementById('error-reg-alert').style.display='none';
    let email = document.getElementById('registerUsername').value;
    let password = document.getElementById('registerPassword').value;
    if(!email && ! password){
        alert('Please provide the email and use password');
        return;
    }
    createUserWithEmailAndPassword(auth,email,password)
    .then((userCredentials)=>{
        document.getElementById('success-reg-alert').innerText='Reegistraion Success';
        document.getElementById('success-reg-alert').style.display='block';
    }).catch((error)=>{
        document.getElementById('error-reg-alert').innerText=error.message;
        document.getElementById('error-reg-alert').style.display='block';
    })
}
const login = ()=>{
    let email = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    if(!email && ! password){
        alert('Please provide the email and use password');
        return;
    }
    signInWithEmailAndPassword(auth,email,password)
    .then((userCredentials)=>{
        document.getElementById('success-reg-alert').innerText='Reegistraion Success';
        document.getElementById('success-reg-alert').style.display='block';
    }).catch((error)=>{
        document.getElementById('error-reg-alert').innerText=error.message;
        document.getElementById('error-reg-alert').style.display='block';
    })
}
window.registerNow = registerNow;
window.login = login;

