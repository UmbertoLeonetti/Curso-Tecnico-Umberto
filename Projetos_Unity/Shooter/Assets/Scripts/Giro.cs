using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Giro : MonoBehaviour
{
    public float velocidade = 180.0f;
    private bool emX = false;
    private bool emY = false;
    private bool emZ = false;

    // Start is called before the first frame update
    void Start()
    {
        emX = (Random.value > 0.4f);
        emY = (Random.value > 0.4f);
        emZ = (Random.value > 0.4f);
    }

    // Update is called once per frame
    void Update()
    {
        if(emY)
        {
            gameObject.transform.Rotate(Vector3.up * velocidade * Time.deltaTime, Space.World);
        }
        if (emX)
        {
            gameObject.transform.Rotate(Vector3.right * velocidade * Time.deltaTime, Space.World);
        }
        if (emZ)
        {
            gameObject.transform.Rotate(Vector3.back * velocidade * Time.deltaTime, Space.World);
        }
    }
}
