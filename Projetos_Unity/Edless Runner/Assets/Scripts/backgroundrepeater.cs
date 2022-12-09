using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class backgroundrepeater : MonoBehaviour {

    public float offset = 17.5f;

    private Transform cameraTransform;

    void Start(){
        cameraTransform = Camera.main.transform;
    }

    void Update() {
        if ((transform.position.x + offset) < cameraTransform.position.x)
        {
            Vector3 newPos = transform.position;
            newPos.x += 2 * offset;
            transform.position = newPos;
        }
    } 

}
