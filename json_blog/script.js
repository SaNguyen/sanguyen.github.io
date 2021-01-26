(function () {
    "use strict";

    window.addEventListener("load",async function () {
        document.querySelector('#getposts').addEventListener("click",getpostClick);
    });

    let userId;
    let server;

    async function getpostClick () {
            userId = document.getElementById("id").value;
            server= "https://jsonplaceholder.typicode.com";
            //get User infor
            let resInfo = await fetch(server + "/users/" + userId);

            let userInfo = document.getElementById("userInfo");
            let userPosts = document.getElementById("userPosts");

            if(resInfo.ok){
                let user = await resInfo.json();
                let divInfo = `<div>Name: ${user.name}</div>`;
                divInfo += `<div>Email: ${user.email}</div>`;
                divInfo += `<div>Phone: ${user.phone}</div>`;
                        
                userInfo.innerHTML = divInfo;
  
                //get posts
                let resPosts = await fetch(server + "/users/" + userId + "/posts/"); 

                if(resPosts.ok){
                    let posts = await resPosts.json();
                    // console.log(posts);
                    userPosts.innerHTML = "";
                    for(let post of posts){
                        // console.log(post);
                        let divPost = `<div class="post">`;
                        divPost += `<div class="title">Title: ${post.title}</div>`;
                        divPost += `<div>Body: ${post.body}</div>`;
                        divPost += `<div><button class="btncomment" data-post-id="${post.id}">Comments</button></div>`
                        divPost += `<div id="comments_${post.id}"></div></div>`
                        userPosts.innerHTML += divPost;
                    }

                    let btnComments = document.querySelectorAll('.btncomment');
                    for(let btn of btnComments){
                        btn.onclick = commentClick;
                    }
                }                
            }
            else{
                document.getElementById("userInfo").innerHTML = "User not found!";
                document.getElementById("userPosts").innerHTML = "";
                
            }
        }


    async function commentClick(){

        let postId = this.dataset.postId;
        let commentsID = document.getElementById(`comments_${postId}`);

        //get comments
        let resComments = await fetch(server + "/posts/" + postId + "/comments"); 
        
        // console.log(resComments);
        if(resComments.ok){
            let comments = await resComments.json();

            for(let com of comments){
                // console.log(com);
                let divCom = `<div class="comment">`;
                divCom += `<div>Name: ${com.name}</div>`;
                divCom += `<div>Email: ${com.email}</div>`;
                divCom += `<div>Body: ${com.body}</div></div>`;
                commentsID.innerHTML += divCom;
            }
        }
    }

})();
