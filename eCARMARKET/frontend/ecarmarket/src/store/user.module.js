import UserService from "@/services/user.service"

export const userService={
    actions:{
        getPersonal(user){
            return UserService.getProfile(user).then(
                user=>{
                    return Promise.resolve(user)
                },
                error=>{
                    return Promise.reject(error)
                }
            );
        },
    }
}