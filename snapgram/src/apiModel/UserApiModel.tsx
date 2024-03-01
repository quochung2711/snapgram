import { apiGet, apiPost } from "@/apiConfig/ApiModel";
import { Login, User } from "@/model";

export async function UserLogin(login: Login) {
    try {
        return apiGet(`sign-in`, login)
    } catch (error) {
       return error;
    }
}

export async function UserRegister(user: User) {
    try {
        return apiPost(`sign-up`, user)
    } catch (error) {
        return error;
    }
}